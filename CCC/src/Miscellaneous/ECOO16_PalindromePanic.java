package Miscellaneous;

import java.util.*;

public class ECOO16_PalindromePanic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < 10; k++) {
            String in = sc.next();
            String tmp;
            int right = 0, left = 0;
            for (int i = 0; i < in.length(); i++) {
                tmp = in.substring(0, i);
                if (check(tmp) && tmp.length() > right)
                    right = tmp.length();
            }
            for (int i = in.length(); i >= 0; i--) {
                tmp = in.substring(i);
                if (check(tmp) && tmp.length() > left)
                    left = tmp.length();
            }
            if (right > left)
                System.out.println(in.length()-right);
            else
                System.out.println(in.length()-left);
        }
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
