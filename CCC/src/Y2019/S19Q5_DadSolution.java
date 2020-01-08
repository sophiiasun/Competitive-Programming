package Y2019;

import java.util.Scanner;

public class S19Q5_DadSolution {
    static int[][] in;
    static int N;
    static int K;

    public static void main(String[] args) {
        init();
        run();
        print();
    }

    static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        in = new int[N][];
        for (int r = 0; r < N; r++) {
            in[r] = new int[r+1];
            for (int c = 0; c < r+1; c++) {
                in[r][c] = scanner.nextInt();
            }
        }
    }

    static void run() {
        int n = N - 1;
        int end = N - K;
        while (n > end) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c <=r; c++) {
                    in[r][c] = Math.max(in[r][c], Math.max(in[r+1][c], in[r+1][c+1]));
                }
            }
            n--;
        }
    }

    static void print() {
        long sum = 0;
        for (int r=0; r <N-K+1; r++) {
            for (int c=0; c <= r; c++) {
                sum += in[r][c];
            }
        }
        System.out.println(sum);
    }
}
