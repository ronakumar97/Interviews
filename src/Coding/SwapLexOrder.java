package Coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class SwapLexOrder {

    public static String getString(String str, int[][] pairs) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < pairs.length; i++) {
            int first = pairs[i][0];
            int second = pairs[i][1];

            first--;
            second--;

            char[] chars = str.toCharArray();
            char c = chars[first];
            chars[first] = chars[second];
            chars[second] = c;

            str = new String(chars);
        }

        Collections.sort(list);

        return list.get(0);
    }
    public static void main(String[] args) {
        String str = "cbda";
        char[] chars = str.toCharArray();
        char c = chars[2];
        chars[2] = chars[3];
        chars[3] = c;

        str = new String(chars);
        System.out.println(str);


        List<String> list = Arrays.asList("cbda", "cbad", "dbac", "dbca");
        Collections.sort(list);

        System.out.println(list.get(list.size()-1));


//        getString("abdc", pairs);
    }
}
