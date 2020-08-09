package DMOPC.Y2014;

import java.util.*;
import java.io.*;

public class DMOPC14C1P3_Sawmill {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a1[] = new int[N], a2[] = new int[N];
        for (int i = 0; i < N; i++) a1[i] = readInt();
        for (int i = 0; i < N; i++) a2[i] = readInt();
        Arrays.sort(a1); Arrays.sort(a2);
        long ans = 0;
        for (int i = 0; i < N; i++)
            ans += ((long)a1[i]*(long)a2[N-i-1]);
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
