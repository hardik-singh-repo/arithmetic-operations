.PHONY: build clean debug run
JAVAC := javac
JAVA := java
BUILD_DIR := build
SOURCE := src
ALGS4_JAR := lib/algs4.jar

# Program arguments forwarded to the Java program. Example:
# make run CLASS=PercolationStats ARGS="30 40"
ARGS ?=

build: 
	@mkdir -p $(BUILD_DIR) 
	@$(JAVAC) -cp ".:$(ALGS4_JAR)" $(SOURCE)/*.java -d $(BUILD_DIR)

run: build
	$(JAVA) -cp "$(BUILD_DIR):$(ALGS4_JAR)" $(CLASS) $(ARGS)

clean: 
	@rm -rf $(BUILD_DIR)/*
