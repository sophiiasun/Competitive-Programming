package Olympiads;

import java.util.*;
import java.io.*;

public class TheCakeIsADesert {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), K = readInt();
        long pda[][] = new long[M+2][N+2], arr[][] = new long[M+2][N+2], psa[][] = new long[M+2][N+2];
        int c, r, C, R;
        for (int i = 0; i < K; i++) {
            c = readInt(); r = readInt(); C = readInt(); R = readInt();
            pda[r][c]++; pda[R+1][c]--; pda[r][C+1]--; pda[R+1][C+1]++;
        }
        for (r = 1; r <= M+1; r++) {
            for (c = 1; c <= N+1; c++) {
                arr[r][c] = arr[r-1][c] + arr[r][c-1] - arr[r-1][c-1] + pda[r][c]; // + psa[r-1][c] + psa[r][c-1];
//                psa[r][c] = psa[r-1][c] + psa[r][c-1];
            }
//            psa[1][1] = arr[1][1];
            for (c = 1; c <= N+1; c++) {
                psa[r][c] = arr[r][c] + psa[r-1][c] + psa[r][c-1] - psa[r-1][c-1];
            }
        }
        int Q = readInt();
        for (int i = 0; i < Q; i++) {
            c = readInt(); r = readInt(); C = readInt(); R = readInt();
            System.out.println(psa[R][C] - psa[R][c-1] - psa[r-1][C] + psa[r-1][c-1]);
        }
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
