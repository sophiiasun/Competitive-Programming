package USACO.Gold20Jan;

import java.util.*;
import java.io.*;

public class P2_FarmerJohnSolves3SUM {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, Q, cnt[], a[], MV = (int)1e6+2;
    static long psa[][];

    public static void main(String[] args) throws IOException {
        N = readInt(); Q = readInt(); a = new int[N+5]; psa = new long[N+5][N+5]; cnt = new int[MV<<1];
        for (int i = 1; i <= N; i++) { a[i] = readInt();        }
        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                int tmp = -a[i] - a[j] + MV;
                if (tmp >= 0 && tmp < MV<<1) psa[i][j] = cnt[tmp];
                cnt[a[j] + MV]++;
            }
            for (int j = i+1; j <= N; j++) cnt[a[j]+MV]--;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) psa[i][j] += psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
        }
        for (int i = 1, x, y; i <= Q; i++) {
            x = readInt(); y = readInt();
            System.out.println(psa[y][y] - psa[x-1][y] - psa[y][x-1] + psa[x-1][x-1]);
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
