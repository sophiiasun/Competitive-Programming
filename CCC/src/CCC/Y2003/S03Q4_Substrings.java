package CCC.Y2003;

import java.util.*;

public class S03Q4_Substrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String in = sc.next();
            char[] aS = new char[in.length()];
            for (int j = 0; j < in.length(); j++)
                aS[j] = in.charAt(j);
            run(aS);
        }
    }
    static void run(char[] aS){
        int N = aS.length;
        int cnt = 0;
        for (int i = 0; i < 1 << N; i++) {
            System.out.print("{");
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0)
                    System.out.print(aS[j] + " ");
            }
            System.out.println("}");
            cnt++;
        }
        System.out.println(cnt);
    }
}
