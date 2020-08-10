package COCI.Y2018;

import java.util.*;
import java.io.*;

public class COCI18C1P4_Strah {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt();

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
