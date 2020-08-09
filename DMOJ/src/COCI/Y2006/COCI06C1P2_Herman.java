package COCI.Y2006;

import java.util.*;
import java.io.*;

public class COCI06C1P2_Herman {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        double pi = 3.14159265358979323846264, a1 = pi*N*N, a2 = 2*N*N;
        System.out.println(String.format("%.6f", a1));
        System.out.println(String.format("%.6f", a2));
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
