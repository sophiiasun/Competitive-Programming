package COCI.Y2019;

import java.util.*;
import java.io.*;

public class COCI19C6P5_Trener {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // try no hash version

        int N = readInt(), K = readInt(), base = 37, mod = (int)1e9+7;
        HashMap<String, Long> map = new HashMap<>();
        String a[][] = new String[N][];
        for (int i = 0; i < N; i++) a[i] = readLine().split(" ");
        for (int i = 0; i < K; i++) { // first batch
            map.put(a[0][i], 1L);
        }
        for (int i = 1; i < N; i++) { // remaining
            for (int j = 0; j < K; j++) {
                long get = 0L;
                String s1 = a[i][j].substring(0, i), s2 = a[i][j].substring(1, i+1);
                if (s1.equals(s2) && map.containsKey(s1)) get = (get + map.get(s1)) % mod;
                else get = ((get + (map.containsKey(s1) ? map.get(s1):0))%mod + (map.containsKey(s2) ? map.get(s2):0)) % mod;
                map.put(a[i][j], get);
            }
        }
        long ans = 0;
        for (int i = 0; i < K; i++) {
            ans = (ans + map.get(a[N-1][i])) % mod;
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
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
