package Coding;

import java.util.Arrays;

public class BuildPall {

    public static boolean gfg(String str) {
        final int chars = 256;
        int[] count = new int[chars];
        Arrays.fill(count, 0);

        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        int oddcount = 0;

        for(int i = 0; i < chars; i++) {
            if((count[i] & 1) == 1) {
                oddcount++;
            }

            if(oddcount > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(gfg("abcba"));
    }
}
