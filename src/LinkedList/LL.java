package LinkedList;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL {

    static Node head;
    static List<Integer> visited = new ArrayList<>();

    public void insertBeginning(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void append(int data) {
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        Node temp = new Node(data);
        last.next = temp;
        return;
    }

    public void insertAfter(Node prevNode, int data) {
        if(prevNode == null) {
            return;
        }

        Node temp = new Node(data);
        temp.next = prevNode.next;
        prevNode.next = temp;
        return;
    }

    public int length(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public int lengthrec(Node head) {
        if(head == null) return 0;
        if(head.next == null) return 1;
        return 1 + lengthrec(head.next);
    }

    public boolean detectLoop(Node head) {
        while(head != null) {
            if(visited.contains(head.data)) return true;
            visited.add(head.data);
            head = head.next;
        }
        return false;
    }

    public boolean floyd(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }

    public int middleLL(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public boolean isPalUtil(Node right) {
        Node left = head;
        if(right == null) return true;

        boolean isP = isPalUtil(right.next);
        if(isP == false) return false;

        boolean ans = (left.data == right.data);

        left = left.next;

        return ans;
    }

    public boolean isPal(Node head) {
        return isPalUtil(head);
    }

    public static void printLL(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node reverseLL(Node node) {
        Node current = node;
        Node next = null;
        Node prev = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        node = prev;
        return node;
    }

    public static void main(String[] args) {
        LL ll = new LL();
        ll.insertBeginning(1);
        ll.insertBeginning(2);
        ll.insertBeginning(3);
        ll.insertBeginning(4);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(20);
        printLL(head);
//        ll.append(5);
//        printLL(head);
//        ll.insertAfter(head.next.next, 20);
//        printLL(head);
//        System.out.println(ll.length(head));
//        System.out.println(ll.lengthrec(head));
//        System.out.println(ll.detectLoop(head));
//        System.out.println(ll.floyd(head));
//        System.out.println(ll.middleLL(head));
//        System.out.println(ll.isPal(head));
        head = reverseLL(head);
        printLL(head);
    }

}
