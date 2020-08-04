package WK190525;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FieldReduction {

    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt();
    private static int[] arrX = new int[N];
    private static int[] arrY = new int[N];
    private static int[][] input = new int[N][2];
    private static int[][] copy = new int[N][2];

    private static boolean debug = false;
    private static void d(String s) {
        if (debug)
            System.out.println(s);
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
        }
        copy = input.clone();
        Arrays.sort(input, Comparator.comparing(a -> a[0]));
        Arrays.sort(input, Comparator.comparing(b -> b[1]));
        int[] Xs = new int[4];
        int[] Xb = new int[4];
        int[] Ys = new int[4];
        int[] Yb = new int[4];

        for (int i = 0; i < 4; i++) {
            Xs[i] = input[i][0];
            Xb[i] = input[N - i - 1][0];
            Ys[i] = input[i][1];
            Yb[i] = input[N - i - 1][1];
        }

        int temp, out = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        temp = getArea(Xb[i], Xs[j], Yb[k], Ys[l]);
                        d(Xb[i] +","+ Xs[j] +","+ Yb[k] +","+ Ys[l] +": "+ temp);
                        if (temp < out) out = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(Xs));
        System.out.println(Arrays.toString(Xb));
        System.out.println(Arrays.toString(Ys));
        System.out.println(Arrays.toString(Yb));
        System.out.println(out);
    }

    private static int getArea(int Xb, int Xs, int Yb, int Ys) {
        int area = Integer.MAX_VALUE, cnt = 0;
        if (Xb >= Xs && Yb >= Ys) {
            for (int i = 0; i < N; i++) {
                if (input[i][0] < Xs || input[i][0] > Xb || input[i][1] < Ys || input[i][1] > Yb) cnt++;
                if (cnt > 3) break;
            }
            if (cnt <= 3) area = (Xb - Xs) * (Yb - Ys);
        }
        return area;
    }

}