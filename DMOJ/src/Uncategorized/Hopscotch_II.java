package Uncategorized;

import java.util.*;
import java.io.*;

public class Hopscotch_II {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), a[] = new int[N+3];
        Deque<C> dq = new LinkedList<>(); ArrayList<Integer> list = new ArrayList<>();
        dq.addLast(new C(0, 0));
        for (int i = 1; i <= N+1; i++) {
            long x = i <= N ? readLong() : 0;
            while (!dq.isEmpty() && i - dq.peekFirst().a > K) dq.pollFirst();
            a[i] = dq.peekFirst().a;
            long next = dq.peekFirst().b + x;
            while (!dq.isEmpty() && next <= dq.peekLast().b) dq.pollLast();
            dq.addLast(new C(i, next));
        }
        System.out.println(dq.peekLast().b);
        for (int i = a[N+1]; i > 0; i = a[i]) list.add(i);
        for (int i = list.size()-1; i >= 0; i--) System.out.print(list.get(i) + " ");
    }

    static class C {
        int a; long b;
        C (int aa, long bb) { a = aa; b = bb; }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
