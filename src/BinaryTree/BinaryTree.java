package BinaryTree;

import java.util.*;

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

public class BinaryTree {

    Node root;

    BinaryTree() {

    }
    BinaryTree(int data) {
        this.root = new Node(data);
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void insert(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();

            if(temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else {
                queue.add(temp.left);
            }

            if(temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else {
                queue.add(temp.right);
            }
        }
    }

    public static int getHeight(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void printCurrentLevel(Node root, int level) {
        if(root == null) return;
        if(level == 1) System.out.print(root.data + " ");
        else if(level > 1) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    public static void printLevelOrder(Node root) {
        int height = getHeight(root);

        for(int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    public static boolean isSum(Node root) {
        int left = 0;
        int right = 0;

        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if(root.left != null) {
            left = root.left.data;
        }

        if(root.right != null) {
            right = root.right.data;
        }

        return (left + right == root.data) && isSum(root.left) && isSum(root.right);
    }

    public static int findDepth(Node root) {
        int d = 0;
        while(root != null) {
            d++;
            root = root.left;
        }

        return d;
    }

    public static boolean checkPerfect(Node root, int depth, int level) {
        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return (depth == level+1);
        }

        if(root.left == null || root.right == null) {
            return false;
        }

        return checkPerfect(root.left, depth, level+1) && checkPerfect(root.right, depth, level+1);

    }

    public static boolean isPerfect(Node root) {
        int d = findDepth(root);
        return checkPerfect(root, d, 0);
    }

    public static boolean isFull(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);
        return false;
    }

    static Set<Integer> set = new HashSet<>();

    public static boolean checkDuplicates(Node root) {
        if(root == null) {
            return false;
        }

        if(set.contains(root.data)) return true;

        set.add(root.data);

        return checkDuplicates(root.left) || checkDuplicates(root.right);
    }

    public static int sum(Node root) {
        if(root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    public static void printSpiral(Node root) {
        int height = getHeight(root);
        boolean ltr = false;
        for(int i = 1; i <= height; i++) {
            printCurrentLevelSpiral(root, i, ltr);
            ltr = !ltr;
        }
    }

    public static void printCurrentLevelSpiral(Node root, int level, boolean ltr) {
        if(root == null) return;
        if(level == 1) System.out.print(root.data + " ");
        if(level > 1) {
            if(ltr == true) {
                printCurrentLevelSpiral(root.left,level-1, ltr);
                printCurrentLevelSpiral(root.right, level-1, ltr);
            } else {
                printCurrentLevelSpiral(root.right,level-1, ltr);
                printCurrentLevelSpiral(root.left, level-1, ltr);
            }
        }
    }

    public static void printLevel(Node root) {
        if(root == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            System.out.print(temp.data + " ");
            queue.poll();

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }


    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.root = new Node(10);
//        binaryTree.root.left = new Node(8);
//        binaryTree.root.right = new Node(2);
//        binaryTree.root.left.left = new Node(3);
//        binaryTree.root.left.right = new Node(5);
//        binaryTree.root.right.right = new Node(2);
//
//        inOrder(binaryTree.root);
//        System.out.println();
//        preOrder(binaryTree.root);
//        System.out.println();
//        postOrder(binaryTree.root);
//        System.out.println();
//
////        insert(binaryTree.root, 20);
//
//        inOrder(binaryTree.root);
//        System.out.println();
//
//        printLevelOrder(binaryTree.root);
//
//        System.out.println(isSum(binaryTree.root));

        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.root = new Node(10);
//        binaryTree.root.left = new Node(20);
//        binaryTree.root.right = new Node(30);
//        binaryTree.root.left.left = new Node(40);
//        binaryTree.root.left.right = new Node(50);
//        binaryTree.root.right.left = new Node(60);
//        binaryTree.root.right.right = new Node(70);
//
//        System.out.println(isPerfect(binaryTree.root));
//
//        System.out.println(isFull(binaryTree.root));
//
//        System.out.println(checkDuplicates(binaryTree.root));
//
//        System.out.println(sum(binaryTree.root));

//        binaryTree.root = new Node(1);
//        binaryTree.root.left = new Node(2);
//        binaryTree.root.right = new Node(3);
//        binaryTree.root.left.left = new Node(7);
//        binaryTree.root.left.right = new Node(6);
//        binaryTree.root.right.left = new Node(5);
//        binaryTree.root.right.right = new Node(4);

        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.left.left.left = new Node(20);
        binaryTree.root.left.left.right = new Node(50);

//        printSpiral(binaryTree.root);

        printLevel(binaryTree.root);
    }
}
