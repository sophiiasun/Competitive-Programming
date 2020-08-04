package ICPC;

import java.util.*;
import java.io.*;

public class ICPC2016_Camera {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt(), r = readInt(), a[] = new int[n+1], cnt=0, ans=0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) a[readInt()]++;
        for (int i = 1; i <= r; i++) {
            cnt += a[i];
            if (a[i] == 0) dq.addLast(i);
        }
        while (cnt < 2) {
            int x = dq.pollLast();
            a[x]++; cnt++; ans++;
        }
        for (int i = r+1; i <= n; i++) {
            cnt += a[i]; cnt -= a[i-r];
            if (a[i]==0) dq.addLast(i);
            while (cnt < 2) {
                int x = dq.pollLast();
                a[x]++; cnt++; ans++;
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
