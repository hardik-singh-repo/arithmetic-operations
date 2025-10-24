import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTests {
    static ExpressionEvaluator ar;

    @BeforeAll
    static void init() {
        ar = new ExpressionEvaluator();
    }
      
    @Test
    void shouldPerformTwoNumberAddition() {
        String exp = "( 1 + 2 )";
        int result = ar.evaluate(exp);
        assertEquals(result, 3);
    }

    @Test
    void shouldDoMultiplicationAdditionComplexExp() {
        String exp = "( 1 + ( ( 2 * 6 ) + ( 2 * 10 ) ) )";
        int result = ar.evaluate(exp);
        assertEquals(result, 33);
    }

    @Test
    void shouldPerformDivision() {
        String exp = "( 1 + ( ( 2 * 6 ) + ( 2 * 10 ) ) )";
        int result = ar.evaluate(exp);
        assertEquals(result, 33);
    }
}