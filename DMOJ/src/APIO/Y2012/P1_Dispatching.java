package APIO.Y2012;

import java.util.*;
import java.io.*;

public class P1_Dispatching {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M;
    static long max = 0L;
    static Boss[] arr;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); arr = new Boss[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new Boss(readInt(), readInt(), readInt());
        for (int i = N; i >= 1; i--) arr[i].getMax();
        System.out.println(max);
    }

    static class Boss {
        int b, c; long l, m = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        Boss (int bb, int cc, int ll) { b = bb; c = cc; l = ll; }
        void getMax() {
            pq.add(c); m += c;
            while (m > M) m -= pq.poll();
            max = Math.max(max, l * pq.size());
            if (b > 0) {
                if (arr[b].pq.size() > pq.size()) arr[b].pq.addAll(pq);
                else { pq.addAll(arr[b].pq); arr[b].pq = pq; }
                arr[b].m += m;
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
