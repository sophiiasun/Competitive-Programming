package Uncategorized;

import java.util.*;
import java.io.*;

public class UTS18_Restaurants {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), T = readInt(), K = readInt(), V = readInt(), sum = 0, ans = 0;
        int a[] = new int[N+1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < V; i++) a[readInt()]++;
        for (int i = 1; i <= T; i++) {
            sum += a[i];
            if (a[i] == 0) dq.addLast(i);
        }
        if (sum < K) {
            int tmp = K - sum;
            for (int i = 0; i < tmp; i++) {
                int pos = dq.pollLast();
                a[pos]++; sum++; ans++;
            }
        }

        for (int t = T+1; t <= N; t++) {
            sum += a[t]; sum -= a[t-T];
            if (a[t] == 0) dq.addLast(t);
            if (sum < K) {
                int tmp = K - sum;
                for (int i = 0; i < tmp; i++) {
                    int pos = dq.pollLast();
                    a[pos]++; sum++; ans++;
                }
            }
        }

        System.out.println(ans);

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
