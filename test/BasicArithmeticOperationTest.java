import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicArithmeticOperationTest {

    @Test
    void shouldPerformBasicArithmeticOperation() {
        BasicArithmeticOperation ar = new BasicArithmeticOperation();
        String exp = "(1 + 2)";
        int result = ar.evaluate(exp);
        assertEquals(result, 3);
    }
}