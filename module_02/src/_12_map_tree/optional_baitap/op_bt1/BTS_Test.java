package _12_map_tree.optional_baitap.op_bt1;


public class BTS_Test {
    public static void main(String[] args) {
        BTS_BinaryTreeSearch tree = new BTS_BinaryTreeSearch();
        tree.insert(27);
        tree.insert(14);
        tree.insert(10);
        tree.insert(19);
        tree.insert(35);
        tree.insert(31);
        tree.insert(42);
        tree.postOrder();
    }
}
