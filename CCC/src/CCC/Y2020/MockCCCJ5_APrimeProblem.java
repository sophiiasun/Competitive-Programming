package CCC.Y2020;

import java.util.*;
import java.io.*;

public class MockCCCJ5_APrimeProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int D = readInt(); String N = next();
        for (int i = N.length()-D; i > D; i--) {
//            int a =
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
