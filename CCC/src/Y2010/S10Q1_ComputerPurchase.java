package Y2010;

import java.util.*;

public class S10Q1_ComputerPurchase {
    static String str1, str2;
    static int max1, max2;
    public static void main(String[] args) {
        run();
        if (str1 != null && max1 == max2 && str1.compareTo(str2) > 0) {
            System.out.println(str2);
            System.out.println(str1);
        } else {
            if (str1 != null)
                System.out.println(str1);
            if (str2 != null)
                System.out.println(str2);
        }
    }
    static void run(){
        int N, R, S, D; //ram, speed, drive
        String B; // brand
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            B = sc.next();
            R = sc.nextInt();
            S = sc.nextInt();
            D = sc.nextInt();
            int tmp = (R<<1) + (S<<1) + S + D;
            if (tmp > max1) {
                max2 = max1;
                max1 = tmp;
                str2 = str1;
                str1 = B;
            } else if (tmp > max2){
                max2 = tmp;
                str2 = B;
            }
        }
    }
}
