package COCI.Y2014;

import java.util.*;
import java.io.*;

public class COCI14_Coci {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(); N a[] = new N[n+1], ans[] = new N[n+1];
        boolean b[] = new boolean[1951];
        for (int i = 1; i <= n; i++) {
            int x = readInt(), y = readInt();
            a[i] = new N(x+y, x+y+650, i);
            b[a[i].m] = true; b[a[i].M] = true;
        }
//        Arrays.sort()
    }

    static class N {
        int m, M, p;
        N (int mm, int MM, int pp) { m=mm; M=MM; p=pp; }
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
