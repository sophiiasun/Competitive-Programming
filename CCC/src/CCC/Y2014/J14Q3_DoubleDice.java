package CCC.Y2014;

import java.util.*;

public class J14Q3_DoubleDice {
    public static void main(String[] args) {
        int p1 = 100, p2 = 100;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            if (tmp1 > tmp2)
                p2 -= tmp1;
            else if (tmp2 > tmp1)
                p1 -= tmp2;
        }
        System.out.println(p1);
        System.out.println(p2);
    }
}
