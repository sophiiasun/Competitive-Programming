package IvyPath;

import java.util.*;
import java.io.*;

public class QueensProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N;
    static boolean[][] arr;
    static boolean done = false;

    public static void main(String[] args) throws IOException {
        N = readInt();
        boolean[][] ans = solve(0, new boolean[N][N]);

        for (int i = 0; i < N; i++) { // print out map
            for (int j = 0; j < N; j++) {
                System.out.print((ans[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    static boolean[][] solve (int count, boolean[][] arr) { // row by row; count = row number
        if (count == N) {
            done = true;
            return arr;
        }
        boolean[][] next = new boolean[N][N];
        for (int c = 0; c < N; c++) {
            if (valid(count, c, arr)) {
                arr[count][c] = true;
                next = solve (count + 1, arr);
                if (done) break;
                else arr[count][c] = false;
            }
        }
        return next;
    }

    static boolean valid (int r, int c, boolean[][] arr) {
        boolean safe = true;
        for (int i = 0; i < r; i++) { // check column
            if (arr[i][c]) safe = false; // column
        }
        for (int i = 1; i <= r && c-i >= 0; i++) { // diagonally left
            if (arr[r-i][c-i]) safe = false;
        }
        for (int i = 1; i <= r && c+i < r; i++) { // diagonally right
            if (arr[r-i][c+i]) safe = false;
        }
        return safe;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
