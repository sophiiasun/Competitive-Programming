package CCC.Y2017;

import java.util.Scanner;

public class J17Q3_ExactlyElectrical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X1 = sc.nextInt(), Y1 = sc.nextInt();
        int X2 = sc.nextInt(), Y2 = sc.nextInt();
        int dif = Math.abs(X1 - X2) + Math.abs(Y1 - Y2);
        int batts = sc.nextInt();
        System.out.println((dif > batts || (batts - dif) % 2 != 0) ? "N" : "Y");
    }
}
