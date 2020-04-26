package Y2016;

import java.util.*;

public class J16Q3_HiddenPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int max = 1;
        String tmp;
        for (int i = 0; i < in.length(); i++) {
            for (int j = i; j <= in.length(); j++) {
                tmp = in.substring(i, j);
                if (check(tmp) && max < tmp.length())
                    max = tmp.length();
            }
        }
        System.out.println(max);
    }
    static boolean check(String in) {
        StringBuilder sb = new StringBuilder();
        for (int i = in.length()-1; i >= 0; i--)
            sb.append(in.charAt(i));
        if (sb.toString().equals(in))
            return true;
        return false;
    }
}
