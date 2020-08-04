package DWITE;

import java.util.*;
import java.io.*;

public class DWITE09_ThatMissingNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int qq = 0; qq < 5; qq++) {
            int M = readInt(), ans = 0;
            for (int i = 1; i <= M+1; i++) ans += i;
            for (int i = 0; i < M; i++) ans -= readInt();
            System.out.println(ans);
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
