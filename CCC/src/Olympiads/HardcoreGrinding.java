package Olympiads;

import java.util.*;
import java.io.*;

public class HardcoreGrinding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int MAX = 10000003;

    public static void main(String[] args) throws IOException {
        int N = readInt(), pda[] = new int[MAX], cnt=0, ans=0;
        for (int i = 0; i < N; i++) { pda[readInt()]++; pda[readInt()]--; }
        for (int i = 1; i < 10000000; i++) { cnt += pda[i]; ans = Math.max(ans, cnt); }
        System.out.println(ans);
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
