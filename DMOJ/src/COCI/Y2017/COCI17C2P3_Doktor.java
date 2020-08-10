package COCI.Y2017;

import java.util.*;
import java.io.*;

public class COCI17C2P3_Doktor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a[] = new int[N+1], psa[] = new int[N+1];
        ArrayList<Integer>[] cnt = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) cnt[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            a[i] = readInt(); psa[i] = psa[i-1] + (a[i]==i?1:0);
            cnt[i+a[i]].add(Math.abs(a[i]-i));
        }
        for (int i = 1; i <= 2*N; i++) {
            if (cnt[i].size()==0) continue;
            Collections.sort(cnt[i]);
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
