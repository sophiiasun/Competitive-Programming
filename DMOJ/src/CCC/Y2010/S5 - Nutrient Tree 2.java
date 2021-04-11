package CCC.Y2010;

import java.util.*;
import java.io.*;

public class S10Q5_NutrientTree2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int X;
    static String in;

    public static void main(String[] args) throws IOException {
        in = readLine(); init(); X = readInt();
    }

    static void init() {
        
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
