package Stack;
import java.util.ListIterator;
import java.util.Stack;

public class StackCode {

    public static void printNGE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(st.empty()) {
                st.push(arr[i]);
                continue;
            }

            while(!st.empty() && st.peek() < arr[i]) {
                System.out.println(st.peek() + " > " + arr[i]);
                st.pop();
            }

            st.push(arr[i]);
        }

        while(!st.empty()) {
            System.out.println(st.peek() + " > " + "-1");
            st.pop();
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        while(!st.empty()) {
            int key = st.peek();
            st.pop();
            while(!temp.empty() && temp.peek() < key) {
                int popped = temp.peek();
                temp.pop();
                st.push(popped);
            }
            temp.push(key);
        }

        return temp;
    }

    public static Stack<Integer> reverseStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        while(!st.empty()) {
            temp.push(st.pop());
        }
        return temp;
    }

    public static void main(String[] args) {
        int arr[] = { 11, 13, 21, 3 };
        printNGE(arr);
        Stack<Integer> st = new Stack<>();
        st.push(34);
        st.push(3);
        st.push(31);
        st.push(98);
        st.push(92);
        st.push(23);

//        Stack<Integer> ans = sortStack(st);
//        ListIterator<Integer> listIterator = ans.listIterator();
//        while(listIterator.hasNext()) {
//            System.out.print(listIterator.next() + " ");
//        }
//        System.out.println();

        Stack<Integer> ans = reverseStack(st);
        ListIterator<Integer> listIterator = ans.listIterator();
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
    }
}
