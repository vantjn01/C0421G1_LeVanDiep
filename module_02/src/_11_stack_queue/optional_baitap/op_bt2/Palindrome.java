package _11_stack_queue.optional_baitap.op_bt2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Palindrome {
    public static void main(String[] args) {
        String test1 = "able was I ere I saw elba";
        String arr[] = test1.split("");
        Stack stack = new Stack();
        Queue queue = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);
            queue.add(arr[i]);
        }
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            if (stack.pop().equals(queue.poll())){
                result = true;
            } else {
                result = false;
            }
        }
        System.out.println(result);

    }
}
