package Olympiads;

import java.util.*;
import java.io.*;

public class DMOJLand_FakeJudges {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), Q = readInt(), pda[] = new int[N+1], psa[] = new int[N+1];
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) arr[i] = readInt();
        for (int i = 0; i < Q; i++) { pda[readInt()-1]++; pda[readInt()]--; }
        psa[0] = pda[0];
        for (int i = 1; i < N; i++) psa[i] += pda[i] + psa[i-1];
        Arrays.sort(psa); Arrays.sort(arr);
        long ans = 0;
        for (int i = 1; i <= N; i++)
            ans += psa[i] * arr[N-i];
        System.out.println(ans);
    }

    static class C {
        int v, p;
        C (int vv, int pp) { v = vv; p = pp; }
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
