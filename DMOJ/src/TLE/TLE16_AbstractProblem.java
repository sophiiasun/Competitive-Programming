package TLE;

import java.util.*;
import java.io.*;

public class TLE16_AbstractProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 0; t < T; t++) {
            long N = readLong(), count = 0;
            while (N != 1) {
                if (N % 2 == 0) N>>=1;
                else N--;
                count++;
            }
            System.out.println(count+1);
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
