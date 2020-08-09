package DMOPC.Y2014;

import java.util.*;
import java.io.*;

public class DMOPC14C1P2_Tiles {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int W = readInt(), L = readInt(), S = readInt();
        System.out.println((W/S)*(L/S));
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
