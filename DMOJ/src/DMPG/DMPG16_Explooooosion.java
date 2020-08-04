package DMPG;

import java.util.*;
import java.io.*;

public class DMPG16_Explooooosion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static long min = 0, max = 1;
    static int mod = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a[] = new int[N], c1 = 0, c2 = 0, mod = (int)1e9+7, tmp = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < N; i++) {
            a[i] = readInt();
            if (a[i] == 1) c1++;
            else {
                min = (min + a[i]) % mod;
                if (a[i] == 2) c2++;
                if (a[i] < tmp) { tmp = a[i]; idx = i; }
            }
        }
        if (c1 == 1) {
            if (idx >= 0) a[idx]++;
            for (int i = 0; i < N; i++) max = (max * a[i]) % mod;
        } else {
            for (int i = 0; i < N; i++) if (a[i] > 2) c(a[i]);
            if (c1 == c2 + 1) { c2++; c1 -= 2; }
            int n = Math.min(c1, c2);
            for (int i = 0; i < n; i++) c(3);
            c1 -= n; c2 -= n;
            for (int i = 0; i < c2; i++) c(2);
            while (c1 > 4) { c(3); c1 -= 3; }
            if (c1 > 0) c(c1);
        }
        System.out.println(Math.max(1, min));
        System.out.println(max);
    }

    static void c (int a) { max = (max * a) % mod; }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
