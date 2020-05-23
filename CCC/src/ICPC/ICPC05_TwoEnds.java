package ICPC;

import java.util.*;
import java.io.*;

public class ICPC05_TwoEnds {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] tmp = readLine().split(" ");
        while (tmp.length != 1) {
            int[] arr = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++) arr[i] = Integer.parseInt(tmp[i]); // Input
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
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
