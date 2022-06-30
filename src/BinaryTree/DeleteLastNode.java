package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import static BinaryTree.BinaryTree.inOrder;

public class DeleteLastNode {

    public static Node lastLevelNode = null;
    public static Node lastParent = null;

    public void deleteLastNode(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.poll();

            if(temp.left != null) {
                queue.offer(temp.left);

                if(temp.left.left == null && temp.left.right == null) {
                    lastLevelNode = temp.left;
                    lastParent = temp;
                }
            }

            if(temp.right != null) {
                queue.offer(temp.right);
                if(temp.right.left == null && temp.right.right == null) {
                    lastLevelNode = temp.right;
                    lastParent = temp;
                }
            }
        }

        if(lastParent != null && lastLevelNode != null) {
            if(lastParent.right != null) {
                lastParent.right = null;
            }
            else {
                lastParent.left = null;
            }
        } else {
            System.out.println("Empty Tree");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(5);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.right = new Node(5);

        inOrder(root);
        System.out.println();

        DeleteLastNode deleteLastNode = new DeleteLastNode();

        deleteLastNode.deleteLastNode(root);

        inOrder(root);

    }

}
