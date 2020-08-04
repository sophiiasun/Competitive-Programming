package CCC;

import java.util.*;
import java.io.*;

public class CCO08_Candy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), v[] = new int[N], c[] = new int[N];
        for (int i = 0; i < N; i++) { c[i] = readInt(); v[i] = readInt(); }

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
