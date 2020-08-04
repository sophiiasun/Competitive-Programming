package CCC.Y2011;

import java.util.*;
import java.io.*;

public class S11Q1_EnglishOrFrench {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), c = 0; char[] arr;
        for (int i = 0; i < N; i++) {
            arr = readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 's' || arr[j] == 'S') c--;
                else if (arr[j] == 't' || arr[j] == 'T') c++;
            }
        }
        System.out.println(c > 0 ? "English" : "French");
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
