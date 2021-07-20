package _11_stack_queue.thuc_hanh.thuc_hanh1;

public class MyGenericStackClient {
    private static void stackOfString(){
        MyGenericStack<String> stringStack = new MyGenericStack();
        stringStack.push("Five");
        stringStack.push("Four");
        stringStack.push("Three");
        stringStack.push("Two");
        stringStack.push("One");
        System.out.println("Size of stack:"+stringStack.size());
        System.out.print("Popped element:");
        System.out.println(stringStack.pop());
        System.out.println("Size of stack after pop:"+stringStack.size());

    }

    private static void stackOfInteger(){
        MyGenericStack<Integer> stringStack = new MyGenericStack();
        stringStack.push(5);
        stringStack.push(4);
        stringStack.push(3);
        stringStack.push(2);
        stringStack.push(1);
        System.out.println("Size of stack:"+stringStack.size());
        System.out.print("Popped element:");
        System.out.println(stringStack.pop());
        System.out.println("Size of stack after pop:"+stringStack.size());

    }
    public static void main(String[] args) {
        stackOfString();
        stackOfInteger();
    }
}
