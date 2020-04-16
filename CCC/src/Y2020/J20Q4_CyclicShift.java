package Y2020;

import java.util.*;

public class J20Q4_CyclicShift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T = sc.next(), S = sc.next();
        boolean bln = false;
        if (T.contains(S))
            bln = true;
        else {

            StringBuilder sb = new StringBuilder();
            sb.append(S);
            for (int i = 0; i < S.length(); i++) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                if (T.contains(sb))
                    bln = true;
            }
        }
        if (bln) System.out.println("yes");
        else System.out.println("no");
    }
}
