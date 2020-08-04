package CCC.Y2013;

import java.util.*;
import java.io.*;

// FASTER VERSION

public class S13Q5_FactorSolitaire {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), factor, cost = 0;
        while (N > 1) {
            factor = 2;
            while (factor <= Math.sqrt(N) && N%factor != 0)
                factor++;
            if (N % factor == 0) {
                factor = N / factor;
                N -= factor; cost += N/factor;
            } else {
                N--; cost+=N;
            }
        }
        System.out.println(cost);
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
