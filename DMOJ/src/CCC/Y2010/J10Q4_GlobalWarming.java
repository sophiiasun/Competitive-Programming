package CCC.Y2010;

import java.util.*;
import java.io.*;

public class J10Q4_GlobalWarming {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), arr[]; ArrayList<Integer> list = new ArrayList<>(), list2 = new ArrayList<>();
        while (N != 0) {
            if (N == 1) { System.out.println(0); continue; }
            int total = 0, cnt = 0;
            list.clear(); arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = readInt();
//                if (list.contains(arr[i]))
            }
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
