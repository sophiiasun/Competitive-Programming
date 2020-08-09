package COCI.Y2006;

import java.util.*;
import java.io.*;

public class COCI06C2P3_Kolone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int A = readInt(), B = readInt();
        char[] a = readLine().toCharArray(), b = readLine().toCharArray(), out = new char[A+B];
        int T = readInt();
        for (int i = 0; i < A; i++) {
            if (T < i) out[A-1-i] = a[i];
            else if (T >= i + B) out[A-1-i + B] = a[i];
            else out[A-1-i + T-i] = a[i];
        }
        int p = 0;
        for (int i = 0; i < A+B; i++) {
            System.out.print(out[i]==0 ? b[p++] : out[i]);
        } System.out.println();
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
