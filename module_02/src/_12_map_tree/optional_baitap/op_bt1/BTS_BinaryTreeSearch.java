package _12_map_tree.optional_baitap.op_bt1;

import java.sql.SQLOutput;

public class BTS_BinaryTreeSearch {
    public class Node{
        private int value;
        private Node left;
        private Node right;
        Node (int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    public BTS_BinaryTreeSearch(){
        this.root =  null;
    }
    private Node insertRec(Node root,int value){
        if (root == null){
            root = new Node(value);

        }
        if(value<root.value){
            root.left = insertRec(root.left, value);
        } else if(value>root.value){
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    public void insert (int value){
        root = insertRec(root,value);
    }
    private void postOrderRec(Node root){
        if (root != null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.value + " ");
        }
    }
    public void postOrder(){
        postOrderRec(root);
    }
}
