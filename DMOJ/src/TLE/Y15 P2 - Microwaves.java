package TLE;

import java.util.*;
import java.io.*;

public class TLE15P2_Microwaves {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), T = readInt(); C a[] = new C[M];
        for (int i = 0; i < M; i++) a[i] = new C(readInt(), readInt());
        Arrays.sort(a); // this question so confusing ? or am i just bad :/
        PriorityQueue<Long> pq = new PriorityQueue<>(); // stores end time of microwaves
        for (int i = 0; i < N; i++) pq.add(0L);
        long time = 0;
        for (int i = 0; i < M; i++) {
            long cur = pq.poll(); time += cur; // cur is end time of most recent microwave
            if (a[i].t - cur >= T) { System.out.println(cur); return; } // condition satisfied
            if (a[i].t < cur) pq.add(cur+a[i].f); // gotta wait before microwave is available
            else pq.add((long)a[i].t + (long)a[i].f); // microwave available before start time
//            if (wait >= T) { System.out.println(pq.peek()); return; } // first condition satisfied
        }
        System.out.println(pq.peek()); // wait until the very end
    }

    static class C implements Comparable<C> {
        int t, f;
        C (int tt, int ff) { t = tt; f = ff; }
        public int compareTo (C o) { return t - o.t; }
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
