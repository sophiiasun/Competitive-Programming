package DWITE;

import java.util.*;
import java.io.*;

public class DWITE11_LegoLadder {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n, h[], dp[];

    public static void main(String[] args) throws IOException {
        for (int q = 0; q < 5; q++) {
            for (int qq = 0; qq < 3; qq++) {
                n = readInt(); h = new int[n]; dp = new int[1<<n];
                Arrays.fill(dp, -1);
                for (int i = 0; i < n; i++) h[i] = readInt();
                if (run((1<<n)-1) == 1) System.out.print("B");
                else System.out.print("A");
            }
            System.out.println();
        }
    }

    static int run (int mask) {
        if (dp[mask] != -1) return dp[mask];
        if (isIncOrDec(mask)) return dp[mask] = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if((mask & 1<<i) != 0) result |= run(mask - (1<<i));
        }
        return dp[mask] = result==1 ? 0:1;
    }

    static boolean isIncOrDec(int mask) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & 1<<i) != 0) list.add(h[i]);
        }
        boolean inc = true, dec = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)) dec = false;
            if (list.get(i) < list.get(i-1)) inc = false;
        }
        return inc || dec;
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
