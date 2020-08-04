package DMPG;

import java.util.*;
import java.io.*;

public class DMPG18_MusicalChairs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), s[] = new int[N+1]; boolean c[] = new boolean[N+1];
        for (int i = 0; i < K; i++) c[readInt()] = true;
        for (int i = 1; i <= K+1; i++) s[readInt()] = i;
        Stack<Integer> stk = new Stack<>();
        for (int q = 0; q < 2; q++) {
            for (int i = 1; i <= N; i++) {
                if (s[i] > 0) { stk.push(s[i]); s[i] = 0; }
                if (c[i] && !stk.empty()) { c[i] = false; stk.pop(); }
            }
        }
        System.out.println(stk.peek());
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
