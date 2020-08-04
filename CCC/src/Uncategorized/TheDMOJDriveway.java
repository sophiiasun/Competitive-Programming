package Uncategorized;

import java.util.*;
import java.io.*;

public class TheDMOJDriveway {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt(), M = readInt();
        Deque<String> dq = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            String in = next(), state = next();
            if (state.charAt(0) == 'i') dq.addLast(in);
            else {
                if (dq.peekLast().equals(in)) dq.pollLast();
                if (dq.peekFirst().equals(in) && M > 0) { dq.pollFirst(); M--; }
            }
        }
        for (String s : dq) System.out.println(s);
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
