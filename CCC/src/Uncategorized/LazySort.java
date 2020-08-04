package Uncategorized;

import java.util.*;
import java.io.*;

public class LazySort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt(), N;
        for (int q = 1; q <= T; q++) {
            N = readInt();
            int a[] = new int[N], pf=1, pb=N-1; Deque<Integer> dq = new LinkedList<>();
            for (int i = 0; i < N; i++) a[i] = readInt();
            dq.addLast(a[0]);
            boolean flag = false;
            while (pf <= pb) {
                if (a[pf] + 1 == dq.peekFirst()) dq.addFirst(a[pf++]);
                else if (a[pf] - 1 == dq.peekLast()) dq.addLast(a[pf++]);
                else if (a[pb] + 1 == dq.peekFirst()) dq.addFirst(a[pb--]);
                else if (a[pb] - 1 == dq.peekLast()) dq.addLast(a[pb--]);
                else { flag = true; break; }
            }
            if (!flag) System.out.println("Case #" + q + ": yes");
            else System.out.println("Case #" + q + ": no");
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
