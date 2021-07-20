package _11_stack_queue.bai_tap.bai_tap1;

public class TestReverseStackInteger {
    public static void main(String[] args) {
        MyStack<Integer> listInteger = new MyStack<>();
        MyStack<Integer> reverseListInteger = new MyStack<>();
        listInteger.push(6);
        listInteger.push(7);
        listInteger.push(8);
        listInteger.push(8);
        System.out.print("size=" + listInteger.size() + ": ");
        while (!listInteger.isEmpty()) {
            System.out.print(listInteger.peek() + " ");
            reverseListInteger.push(listInteger.pop());
        }
        System.out.print("\nReverse list");
        System.out.print("\nNew list size=" + reverseListInteger.size() + ": ");
        while (!reverseListInteger.isEmpty()) {
            System.out.print(reverseListInteger.pop() + " ");
        }
    }
}
