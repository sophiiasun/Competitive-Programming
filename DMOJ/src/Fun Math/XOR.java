package Fun_Math;

import java.io.*;
import java.util.*;

public class XOR {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), s, f;
        for (int t = 0; t < n; t++) {
            s = readInt(); f = readInt();
            for (int i = s; i < f; i++) {
                s ^= (i + 1);
            }
            System.out.println(s);
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
