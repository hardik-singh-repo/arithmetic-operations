.PHONY: build clean debug run
JAVAC := javac
JAVA := java
BUILD_DIR := build
SOURCE := src
ALGS4_JAR := lib/algs4.jar

# Debugging options (can be overridden on the command line)
DEBUG_PORT ?= 5005
SUSPEND ?= n


# Program arguments forwarded to the Java program. Example:
# make run CLASS=PercolationStats ARGS="30 40"
ARGS ?=

build: 
	@mkdir -p $(BUILD_DIR) 
	@$(JAVAC) -cp ".:$(ALGS4_JAR)" $(SOURCE)/*.java -d $(BUILD_DIR)

run: build
	$(JAVA) -cp "$(BUILD_DIR):$(ALGS4_JAR)" $(CLASS) $(ARGS)

debug: build
	@echo "Starting $(CLASS) in debug mode (jdwp port=$(DEBUG_PORT), suspend=$(SUSPEND))"
	$(JAVA) -agentlib:jdwp=transport=dt_socket,server=y,suspend=$(SUSPEND),address=*:$(DEBUG_PORT) -cp "$(BUILD_DIR):$(ALGS4_JAR)" $(CLASS) $(ARGS)

clean: 
	@rm -rf $(BUILD_DIR)/*
