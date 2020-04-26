package Y2012;

import java.util.*;

public class J12Q4_BigBangSecrets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        String in = sc.next();
//        char[] arr = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder out = new StringBuilder();
        int shift = K;
        for (int i = 1; i <= in.length(); i++) {
            shift += 3;
            char chr = (char) (in.charAt(i-1) - (shift % 26));
            if (chr < 'A')
                chr += 26;
            out.append(chr);
//
//            int tmp = in.charAt(i-1) - 64;
//            if (tmp <= shift) {
//                shift -= tmp;
//                out.append(tmp-shift);
//            } else
//                out.append(arr[tmp-shift]);
        }
        System.out.println(out);
    }
}
