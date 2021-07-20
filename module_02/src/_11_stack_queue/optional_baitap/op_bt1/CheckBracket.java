package _11_stack_queue.optional_baitap.op_bt1;
import java.util.Stack;
public class CheckBracket {
    public static boolean checkBracket(String equation) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            String symbol = equation.substring(i, i + 1);
            if (symbol.equals("(")) {
                stack.push(symbol);
            } else if (symbol.equals(")")) {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
