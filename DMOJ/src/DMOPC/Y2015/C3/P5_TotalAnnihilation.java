package DMOPC.Y2015.C3;

import java.util.*;
import java.io.*;

public class P5_TotalAnnihilation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), arr[] = new int[N+M], h1 = (N+M)>>1, h2 = N+M - h1;
        long sum, ans = -1;
        for (int i = 0; i < N+M; i++) arr[i] = readInt();
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < (1<<h1); i++) { // use bitmask to find all possible sums
            sum = 0;
            for (int j = 0; j < h1; j++) {
                if ((i & (1<<j)) != 0) sum += j >= N ? -arr[j] : arr[j];
            }
            if (!map.containsKey(sum)) map.put(sum, (long)1);
            else map.replace(sum, map.get(sum) + 1);
        }
        for (int i = 0; i < (1<<h2); i++) {
            sum = 0;
            for (int j = 0; j < h2; j++) {
                if ((i & (1<<j)) != 0) sum += h1 + j >= N ? -arr[h1 + j] : arr[h1 + j];
            }
            if (map.containsKey(-sum))
                ans += map.get(-sum);
        }
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
