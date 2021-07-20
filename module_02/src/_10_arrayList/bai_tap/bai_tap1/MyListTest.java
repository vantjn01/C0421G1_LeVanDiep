package _10_arrayList.bai_tap.bai_tap1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<String>(10);
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
        myList.add(2,"T");

        System.out.println("Before remove");
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
        System.out.println(myList.get(4));
        System.out.println("After remove");
        myList.remove(2);
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
    }
}
