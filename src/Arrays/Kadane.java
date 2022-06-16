package Arrays;

import static java.lang.Math.max;

public class Kadane {

    public static int maxSum(int[] array) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending = 0;

        for(int i = 0; i < array.length; i++) {
            max_ending += array[i];
            if(max_so_far < max_ending) {
                max_so_far = max_ending;
            }
            if(max_ending < 0) {
                max_ending = 0;
            }
        }
        return max_so_far;
    }

    public static int betterMax(int[] arr) {
        int max_far = arr[0];
        int current_max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            current_max = max(arr[i], current_max + arr[i]);
            max_far = Integer.max(current_max, max_far);
        }
        return max_far;
    }

    public static void main(String[] args) {
        int [] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(array));
        System.out.println(betterMax(array));
    }
}

