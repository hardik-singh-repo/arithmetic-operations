import java.util.Stack;

/**
 * Using Djikstra's two stack algorithm implement the arithmetic operation.
 */
public class ExpressionEvaluator {
    private Stack<String> operation = new Stack<String>();
    private Stack<Integer> operand = new Stack<Integer>();
    
    /**
     * exp should be space separated for the evaluator to parse the input. e.g: ( ( 1 + 2 ) * 12 ).
     */
    public int evaluate(String exp) {
        String[] sExp = exp.split(" ");
        int res = 0;
        for (int i = 0; i < sExp.length; i++) {
            String c = sExp[i];
            
            //checking if a given number is integer.
            int num = 0;

            try {
                num = Integer.parseInt(c);
            } catch (NumberFormatException ex) {};

            if ( num > 0 ) {
                operand.push(num);
            } else if (c.equals("*") || c.equals("+") || c.equals("-") || c.equals("/")) {
                operation.push(c);
            } else if (c.equals(")")) {
                //if encountered the closing bracket pop the last 2 elements on the operand stack 
                //and pop 1 element from operation stack and store the result back on stack.
                int n1 = operand.pop();
                int n2 = operand.pop();
                String op = operation.pop();

                if (op.equals("+")) {
                    res = n1 + n2;
                } else if (op.equals("-")) {
                    res = n1 - n2;
                } else if (op.equals("*")) {
                    res = n1 * n2;
                } else {
                    res = n1 / n2;
                }
                operand.push(res);
            }
        }

        //size 1 means only the final result is on the stack.
        if (operand.size() == 1){
                res = operand.pop();
        }

        return res;
    }
}
