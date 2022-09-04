package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1991트리순회_hunojung {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree(new Node('A'));
        Node root = tree.root;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c1 = st.nextToken().charAt(0);
            char c2 = st.nextToken().charAt(0);
            char c3 = st.nextToken().charAt(0);
            tree.insert(root,c1,c2,c3);
        }

        tree.preorder(root);
        System.out.println();

        tree.inorder(root);
        System.out.println();

        tree.postorder(root);

        br.close();
        System.exit(0);
    }
}
class Tree{
    Node root;
    public Tree(Node root){
        this.root = root;
    }

    public boolean insert(Node head, char parent, char left_char,char right_char){
        if(head.val == parent){
            if(left_char != '.') head.left = new Node(left_char);
            if(right_char != '.') head.right = new Node(right_char);
            return true;
        }

        if(head.left != null ){
            if(insert(head.left, parent, left_char, right_char)){
                return true;
            }
        }
        if(head.right != null ){
            if(insert(head.right, parent, left_char, right_char)){
                return true;
            }
        }
        return false;
    }

    public void preorder(Node head){
        System.out.print(head.val);
        if(head.left != null) preorder(head.left);
        if(head.right != null) preorder(head.right);
    }

    public void inorder(Node head){
        if(head.left != null) inorder(head.left);
        System.out.print(head.val);
        if(head.right != null) inorder(head.right);
    }

    public void postorder(Node head){
        if(head.left != null) postorder(head.left);
        if(head.right != null) postorder(head.right);
        System.out.print(head.val);
    }
}
class Node{
    char val;
    Node left;
    Node right;
    public Node(char val){
        this.val = val;
    }
}
