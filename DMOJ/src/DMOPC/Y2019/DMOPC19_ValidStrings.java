package DMOPC.Y2019;

import java.util.*;
import java.io.*;

public class DMOPC19_ValidStrings {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        for (int t = 0; t < n; t++) {
            String in = readLine();
            int c = 0; boolean b = true;
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i)==')') {
                    if (c == 0) { b = false; break; }
                    else c--;
                } else if (in.charAt(i)=='(') c++;
            }
            if (c != 0 || !b) System.out.println("NO");
            else System.out.println("YES");
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
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
