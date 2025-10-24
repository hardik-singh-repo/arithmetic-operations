import java.util.Stack;

/**
 * Using Djikstra's two stack algorithm implement the arithmetic operation.
 */
public class BasicArithmeticOperation {
    private Stack<Character> operation = new Stack<Character>();
    private Stack<Integer> operand = new Stack<Integer>();
    
    public int evaluate(String exp) {
        int res = 0;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            
            //checking if a given number is integer.
            int num = Character.getNumericValue(c);
            if ( num > 0 ) {
                operand.push(num);
            } else if (c == '*' || c == '+' || c == '-' || c == '/' ) {
                operation.push(c);
            } else if (c == ')') {
                //if encountered the closing bracket pop the last 2 elements on the operand stack 
                //and pop 1 element from operation stack and store the result back on stack.
                int n1 = operand.pop();
                int n2 = operand.pop();
                char op = operation.pop();

                if (op == '+') {
                    res = n1 + n2;
                } else if (op == '-') {
                    res = n1 - n2;
                } else if (op == '*') {
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
