package BackToSchool;

import java.util.*;
import java.io.*;

public class BTS18_TheGoldenPorcupine {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), T = readInt(), pda[] = new int[T+1];
        for (int i = 0; i < N; i++) {
            int L = readInt(), R = readInt(), a = readInt(), b = readInt(), c = readInt();
            int t1 = c(1, a, b, c), t2 = c(2, a, b, c), t3 = c(3, a, b, c);
            int dif = (t3 - t2) - (t2 - t1);

        }
    }

    static int c(int t, int a, int b, int c) {
        return a*t*t + b*t + c;
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
