package BST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }

        if(data <= root.data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(key <= root.data) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    public static Node lca(Node root, int n1, int n2) {
        while(root != null) {
            if(root.data > n1 && root.data > n2) {
                root = root.left;
            }
            else if(root.data < n1 && root.data < n2) {
                root = root.right;
            }
            else {
                break;
            }
        }

        return root;
    }
    public static boolean isBSTUtil(Node root, int min, int max) {
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        return isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data+1, max);
    }

    public static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean findPair(Node root, int sum) {
        Set<Integer> set = new HashSet<>();
        return findPairUtil(root, sum, set);
    }

    public static boolean findPairUtil(Node root, int sum, Set<Integer> set) {
        if(root == null) return false;
        if(findPairUtil(root.left, sum, set) == true) return true;

        if(set.contains(sum - root.data)) {
            return true;
        } else {
            set.add(root.data);
        }

        return findPairUtil(root.right, sum, set);
    }

    static List<Integer> inOrderList = new ArrayList<>();

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        inOrderList.add(root.data);
        inOrder(root.right);
    }

    public static int inOrderSucc(Node root, int key) {
        inOrder(root);
        for(int i = 0; i < inOrderList.size(); i++) {
            if(inOrderList.get(i) > key) {
                return inOrderList.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;
        root = tree.insert(root, 20);
        tree.insert(root, 8);
        tree.insert(root, 22);
        tree.insert(root, 4);
        tree.insert(root, 12);
        tree.insert(root, 10);
        tree.insert(root, 14);


        System.out.println(findMin(root));
        System.out.println(search(root, 2));
        System.out.println(isBST(root));
        int n1 = 10, n2 = 22;
        Node t = tree.lca(root, n1, n2);
        System.out.println(t.data);

        System.out.println(findPair(root, 100));
        System.out.println(inOrderSucc(root, 14));
    }
}
