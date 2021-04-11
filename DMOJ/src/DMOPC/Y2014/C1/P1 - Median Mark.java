package DMOPC.Y2014.C1;

import java.util.*;
import java.io.*;

public class P1_MedianMark {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a[] = new int[N+1];
        for (int i = 1; i <= N; i++) a[i] = readInt();
        Arrays.sort(a);
        System.out.println(Math.round((a[(N>>1)+1] + (N%2==0?a[N>>1]:0))/(N%2==0?2.0:1)));
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
