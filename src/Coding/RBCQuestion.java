package Coding;

public class RBCQuestion {

    public static String helper(String test, boolean isDecimal) {
        String ans = "";
        int i = 0;
        while(i < test.length()) {
            ans += test.charAt(i);
            if(i % 2 == 0) {
                ans += ',';
            }
            i++;
        }
        return ans;
    }

    public static boolean hasDecimal(String test) {
        for(int i = 0; i < test.length(); i++) {
            if(test.charAt(i) == '.') return true;
        }
        return false;
    }

    public static String help(String test, boolean isDecimal) {
        if(!isDecimal) {
            if(test.length() % 2 == 0) {
                int i = 0;
                while(i < test.length()) {

                }
            }
        }
    }

    public static String result(String test) {
        String ans = "";
        boolean isDecimal = hasDecimal(test);
        if(test.charAt(0) == '-') {
            ans += "-";
            ans += help(test, isDecimal);
        } else {
            ans += help(test, isDecimal);
        }

    }
//    public static String result(String test) {
//        String ans = "";
//        boolean isDecimal = false;
//        if(hasDecimal(test)) {
//            isDecimal = true;
//        }
//        if(test.charAt(0) == '-') {
//            ans += '-';
//            ans += helper(test.substring(1), isDecimal);
//        } else {
//            ans += helper(test, isDecimal);
//        }
//
//        if(ans.charAt(ans.length()-1) == ',') {
//            ans = ans.substring(0, ans.length()-1);
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
        String test = "-123456789101.44";
        System.out.println(result(test));
    }
}
