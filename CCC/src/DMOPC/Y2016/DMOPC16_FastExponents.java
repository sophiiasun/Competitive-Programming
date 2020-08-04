package DMOPC.Y2016;

import java.util.*;
import java.io.*;

public class DMOPC16_FastExponents {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(); long n;
        for (int i = 0; i < N; i++) {
            n = readLong();
            if ((n & n-1) == 0) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
