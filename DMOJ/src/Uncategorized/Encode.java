package Uncategorized;

import java.util.*;
import java.io.*;

public class Encode {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String UP = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LO = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        int N = readInt(); String S = readLine();
        if (N < 0) N = 26 - (Math.abs(N) % 26);
        else N %= 26;
        if (N == 0) { System.out.println(S); return; }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (UP.indexOf(c) >= 0) System.out.print(UP.charAt(UP.lastIndexOf(c) - N));
            else if (LO.indexOf(c) >= 0) System.out.print(LO.charAt(LO.lastIndexOf(c) - N));
            else System.out.print(" ");
        } System.out.print("\n");
    }

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
