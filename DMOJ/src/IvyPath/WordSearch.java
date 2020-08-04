package IvyPath;

import java.util.*;
import java.io.*;

public class WordSearch {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static char[][] arr;
    static int R, C, Q;

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt(); Q = readInt();
        for (int i = 0; i < R; i++) {
            arr[i] = readLine().toCharArray();
        } String in;
        for (int q = 0; q < Q; q++) {
            boolean found = false;
            in = readLine();
            for (int i = 0; i < R && !found; i++) {
                for (int j = 0; j < C && !found; j++) {
//                    if (arr[i][j] == in.charAt(0))
//                        found = run(in, 0, i, j);
                }
            }
            System.out.println(found);
        }
    }

//    static boolean run(String s, int idx, int r, int c) {
//
//    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
