package GFSSOC;

import java.util.*;
import java.io.*;

// Original Question Name: Or-Deal

public class OR_Deal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long N = readLong();
        int count = 1;
        while (N >> count > 0) count++; count--;
        for (int i = count; i >= 0; i--) {
            System.out.print(N>>count | 1);
        } System.out.println();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
