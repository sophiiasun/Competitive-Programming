package DMOPC.Y2019;

import java.util.*;
import java.io.*;

public class DMOPC19_GeneratingNames {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, cnt[] = new int[26];
    static long arr[] = new long[17];

    public static void main(String[] args) throws IOException {
        N = readInt(); K = readInt();
        arr[0] = 1;
        for (int i = 1; i < 16; i++) arr[i] = arr[i-1] * i;
        String in = next();
        for (int i = 0; i < N; i++) {
            if (in.charAt(i) != '*') cnt[in.charAt(i) - 'a']++;
        }
        System.out.println(run(0, K));
    }

    static long run (int idx, int k) {
        if (k > 0) {
            long ans = arr[N];
            for (int i = 0; i < 26; i++) ans /= arr[cnt[i]];
            return ans;
        }
        long res = 0;
        for (int i = idx; i < 26; i++) {
            cnt[i]++;
            res += run(i, k-1);
            cnt[i]--;
        }
        return res;
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
