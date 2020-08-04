package CCO;

import java.util.*;
import java.io.*;

public class CCO05_Candy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), total = 0;
        Candy[] arr = new Candy[N + 1];
        for (int i = 1; i <= N; i++) { // Input
            arr[i] = new Candy(readInt(), readInt());
            total += arr[i].c * arr[i].k;
        }
        boolean[] dp = new boolean[total + 1];

        Arrays.sort(arr);

        int[] dp1 = new int[N+1], dp2 = new int[N+1], tmp;

        for (int n = 1; n <= N; n++) { // Go through each different size of candy
            Candy curr = arr[n];

        }

        for (int i = total>>1; i >= 0; i--) {
            if (dp[i]) {
                System.out.println(total - 2*dp1[i]);
                return;
            }
        }

    }

    static class Candy {
        int k, c;
        Candy (int pk, int pc) { k = pk; c = pc; }
        public int compareTo (Candy other) { return other.c - c; }
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
