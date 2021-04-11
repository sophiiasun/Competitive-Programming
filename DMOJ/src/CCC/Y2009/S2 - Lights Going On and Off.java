package CCC.Y2009;

import java.util.*;
import java.io.*;

public class S09Q2_LightsGoingOnAndOff {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int R = readInt(), C = readInt(), a[] = new int[R];
        for (int i = 0; i < R; i++) { // Read input as integer for each row
            for (int j = 0; j < C; j++) a[i] = a[i] << 1 | readInt();
        }
        Set<Integer>[] set = new HashSet[R];
        for (int i = 0; i < R; i++) set[i] = new HashSet<>();
        set[0].add(a[0]);
        for (int i = 1; i < R; i++) {
            set[i].add(a[i]);
            for (int n : set[i-1]) set[i].add(a[i] ^ n);
        }
        System.out.println(set[R-1].size());
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
