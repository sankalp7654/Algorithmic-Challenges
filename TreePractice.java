import java.util.*;

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreePractice {

    public static void main(String[] args) {
        
        Tree root = null;

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Insert");
            System.out.println("2 - Inorder");
            int key = scanner.nextInt();

            switch (key) {
                case 1:
                    System.out.println("Enter the value");
                    int value = scanner.nextInt();
                    root = insertNode(root, value);
                    break;
                
                case 2:
                    inOrder(root);
                    System.out.println();
                    break;

                default:
                    break;
            }
        }
    }

    public static Tree insertNode(Tree root, int data) {

        Tree newNode = new Tree(data);
        if(root == null) {
            return newNode;
        }

        Tree t = root;
        
        while(true) {
            if(data > t.data) {
                if(t.right == null) {
                    t.right = newNode;
                    break;
                }
                t = t.right;
            }
            else {
                if(t.left == null) {
                    t.left = newNode;
                    break;
                }
                t = t.left;
            }
        }
        return root;
    }

    public static void inOrder(Tree root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}