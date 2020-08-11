package WAC;

import java.util.*;
import java.io.*;

public class P3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a[] = new int[N], c[] = new int[N+1], ans = 0;
        for (int i = 0; i < N; i++) a[i] = readInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            if ((double)Math.round(Math.sqrt(i)) - (double)Math.sqrt(i) == 0.0) {
                Arrays.fill(c, 0); set.clear();
                for (int j = 0; j < i; j++) { set.add(a[j]); c[a[j]]++; }
                boolean flag = false;
                for (int v : set) { if (c[v] != set.size()) { flag = true; break;} }
                if (!flag) ans ++;
                for (int j = i; j < N; j++) {
                    set.add(a[j]); c[a[j]]++; // insert
                    if (c[a[j - i]] == 1) set.remove(a[j - i]); // remove
                    c[a[j - i]]--;
                    flag = false;
                    for (int v : set) { if (c[v] != set.size()) flag = true; }
                    if (!flag) ans++;
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
