package _10_arrayList.bai_tap.bai_tap2;
import java.util.LinkedList;
public class MyLinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        // add first
        linkedList.addFirst(10);
        // Show list through for-each
        System.out.println();
        for (int obj : linkedList) {
            System.out.print(obj + "\t");
        }
        // add last
        linkedList.addLast(20);
        // Show list through index
        System.out.println();
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(linkedList.get(i) + "\t");
        }
        System.out.println("");
        //lấy phần tử
        System.out.println(linkedList.get(0));
        //lấy phần tử đầu tiên
        System.out.println(linkedList.getFirst());
        //lấy phần tử cuối cùng
        System.out.println(linkedList.getLast());
        //lấy kích thước list
        System.out.println(linkedList.size());
        //Lấy vị rí
        System.out.println(linkedList.indexOf(10));
        //kiểm tra có phần tử đó không
        System.out.println(linkedList.contains(1));
        //clear
        linkedList.clear();
        for (int i = 0; i < size; i++) {
            System.out.print(linkedList.get(i) + "\t");
        }

    }
}
