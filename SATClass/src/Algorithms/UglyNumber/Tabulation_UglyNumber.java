package Algorithms.UglyNumber;

// A number is ugly if its only prime factors are 2, 3, 5

import java.util.*;

public class Tabulation_UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        double time = System.nanoTime();
        if (N == 1) System.out.println("1");
        else {
            int i2 = 0, i3 = 0, i5 = 0;
            int chk2 = 2, chk3 = 3, chk5 = 5;
            arr[0] = 1;
            for (int i = 1; i < N; i++) {
                int temp = getMin(chk2, chk3, chk5);
                arr[i] = temp;
                if (temp == chk2) {
                    i2++;
                    chk2 = arr[i2] * 2;
                }
                if (temp == chk3) {
                    i3++;
                    chk3 = arr[i3] * 3;
                }
                if (temp == chk5) {
                    i5++;
                    chk5 = arr[i5] * 5;
                }
            }
            System.out.println(arr[N-1]);
        }
        System.out.println(System.nanoTime() - time);
    }

    private static int getMin (int A, int B, int C) {
        int temp = A;
        if (temp > B) temp = B;
        if (temp > C) temp = C;
        return temp;
    }

}
