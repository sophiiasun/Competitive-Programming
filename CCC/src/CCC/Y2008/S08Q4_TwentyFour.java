package CCC.Y2008;

import java.util.*;

public class S08Q4_TwentyFour {

    static int max = 0;
    static boolean done;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            done = false;
            Integer[] arr = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            Arrays.sort(arr, Collections.reverseOrder());
            run(arr[1], arr[2], arr[3], 0, arr[0]);
            run(arr[0], arr[2], arr[3], 0, arr[1]);
            run(arr[0], arr[1], arr[3], 0, arr[2]);
            run(arr[0], arr[1], arr[2], 0, arr[3]);
            System.out.println(max);
            max = 0;
        }
    }

    static void run(int A, int B, int C, int D, int total) {
        if (!done) {
            if (B > 0 && C > 0) {
                run(A, B + C, D, 0, total);
                run(A, B - C, D, 0, total);
                run(A, B * C, D, 0, total);
                if (B % C == 0)
                    run(A, B / C, D, 0, total);
            }
            if (A > 0 && B > 0) {
                run(A + B, C, D, 0, total);
                run(A - B, C, D, 0, total);
                run(A * B, C, D, 0, total);
                if (A % B == 0)
                    run(A / B, C, D, 0, total);
            }
            if (A > 0 && C > 0) {
                run(A + C, B, D, 0, total);
                run(A - C, B, D, 0, total);
                run(A * C, B, D, 0, total);
                if (A % C == 0)
                    run(A / C, B, D, 0, total);
            }
            if (A > 0) {
                run(B, C, D, 0, total + A);
                run(B, C, D, 0, total - A);
                run(B, C, D, 0, total * A);
                if (total % A == 0)
                    run(B, C, D, 0, total / A);
            } else if (B > 0) {
                run(A, C, D, 0, total + B);
                run(A, C, D, 0, total - B);
                run(A, C, D, 0, total * B);
                if (total % B == 0)
                    run(A, C, D, 0, total / B);
            } else if (C > 0) {
                run(A, B, D, 0, total + C);
                run(A, B, D, 0, total - C);
                run(A, B, D, 0, total * C);
                if (total % C == 0)
                    run(A, B, D, 0, total / C);
            } else if (D > 0) {
                run(A, B, C, 0, total + D);
                run(A, B, C, 0, total - D);
                run(A, B, C, 0, total * D);
                if (total % D == 0)
                    run(A, B, C, 0, total / D);
            }
            if (A == 0 && B == 0 && C == 0 && D == 0 && total > max && total <= 24) {
                max = total;
                if (max == 24)
                    done = true;
            }
        }
    }
}
