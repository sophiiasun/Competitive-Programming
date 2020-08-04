package DMOPC.Y2015;

import java.util.*;
import java.io.*;

public class DMOPC15_GreatSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), Q = readInt(), arr[] = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = arr[i-1] + readInt();
        for (int q = 0; q < Q; q++) {
            int a = readInt(), b = readInt(), x = readInt(), y = readInt();
            boolean b1 = false, b2 = false;
            for (int i = x; i <= y && (!b1 || !b2); i++) {
                if (arr[i]-arr[i-1] == a) b1 = true;
                if (arr[i]-arr[i-1] == b) b2 = true;
            }
            if (arr[y] - arr[x-1] <= K || !(b1&b2)) System.out.println("No");
            else System.out.println("Yes");
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
