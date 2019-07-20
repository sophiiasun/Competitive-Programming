package WK190525;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class FieldReduction_i {

    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt();
    private static int[] arrX = new int[N];
    private static int[] arrY = new int[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            arrX[i] = sc.nextInt();
            arrY[i] = sc.nextInt();
        }
        Arrays.sort(arrX);
        Arrays.sort(arrY);
        int[] Xs = getXs(arrX);
        int[] Ys = getYs(arrY);
        int[] Xb = getXb(arrX);
        int[] Yb = getYb(arrY);

        int area = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        area = getArea(Xb[i], Xs[j], Yb[k], Ys[l]);
                    }
                }
            }
        }

        System.out.println(area);

    }

    private static int getArea(int Xb, int Xs, int Yb, int Ys) {
        int area = MAX_VALUE, Atmp, cnt = 0;
        boolean bln = true;
        if (Xb < Xs || Yb < Ys) bln = false;
        if (bln) {
            for (int i = 0; i < N; i++) {
                if (arrX[i] < Xs || arrX[i] > Xb || arrY[i] < Ys || arrY[i] > Yb) cnt++;
                if (cnt > 3) {
                    bln = false;
                    break;
                }
            }
        }
        if (!bln) return area;
        else {
            Atmp = (Xb - Xs) * (Yb - Ys);
            if (Atmp < area) {
                area = Atmp;
            }
            return area;
        }
    }

    private static int[] getXs(int[] arr) {
        int[] newXs = new int[4];
        for (int i = 0; i < 4; i++) {
            newXs[i] = arr[i];
        }
        return newXs;
    }

    private static int[] getYs(int[] arr) {
        int[] newY = new int[4];
        for (int i = 0; i < 4; i++) {
            newY[i] = arr[i];
        }
        return newY;
    }

    private static int[] getXb(int[] arr) {
        int[] newXs = new int[4];
        for (int i = 0; i < 4; i++) {
            newXs[i] = arr[arr.length - i - 1];
        }
        return newXs;
    }

    private static int[] getYb(int[] arr) {
        int[] newYb = new int[4];
        for (int i = 0; i < 4; i++) {
            newYb[i] = arr[arr.length - i - 1];
        }
        return newYb;
    }

}