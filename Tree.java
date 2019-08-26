import java.util.Scanner;

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
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
        while(t != null) {
            if(t == null) {
                t = newNode;
            }
            if(data > t.data) {
                t = t.right;
            }
            else {
                t = t.left;
            }
        }
    }

    public static void inOrder(Tree root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}