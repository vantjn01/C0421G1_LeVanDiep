package _11_stack_queue.bai_tap.bai_tap1;

public class TestReverseStackString {
    public static void main(String[] args) {
        MyStack<Character> charList = new MyStack<>();
        MyStack<Character> reverseCharList = new MyStack<>();
        String str = "VANDIEP";
        for (char s : str.toCharArray()) {
            charList.push(s);
            System.out.print(s + "");
        }
        System.out.println();
        System.out.print("Reverse List: ");
        while (!charList.isEmpty()) {
            System.out.print(charList.peek() + "");
            reverseCharList.push(charList.pop());
        }
    }
}
