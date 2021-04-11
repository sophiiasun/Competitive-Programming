package DMOPC.Y2019.C1;

import java.util.*;
import java.io.*;

public class DMOPC19_Yikes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String a = next(), b = next(); int c = 0;
        if (a.length() != b.length()) { System.out.println("LARRY IS DEAD!"); return; }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) c++;
        }
        if (c == 1) System.out.println("LARRY IS SAVED!");
        else System.out.println("LARRY IS DEAD!");
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
