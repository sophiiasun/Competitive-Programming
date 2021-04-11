package CCC.Y2012;

import java.util.*;

public class J12Q4_BigBangSecrets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        String in = sc.next();
        StringBuilder out = new StringBuilder();
        int shift = K;
        for (int i = 1; i <= in.length(); i++) {
            shift += 3;
            char chr = (char) (in.charAt(i-1) - (shift % 26));
            if (chr < 'A')
                chr += 26;
            out.append(chr);
        }
        System.out.println(out);
    }
}
