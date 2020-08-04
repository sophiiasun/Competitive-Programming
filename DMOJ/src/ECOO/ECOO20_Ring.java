package ECOO;

import java.util.*;
import java.io.*;

public class ECOO20_Ring {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int mod = (int)1e9+7;
        for (int T = readInt(); T > 0; T--) {
            int N = readInt(); Map<String, pair> func = new HashMap<>();
            Stack<String> st = new Stack<>();
            func.put("main", new pair(1, 0)); st.push("main");
            for (int i = 0; i <= N; i++) {
                String s = next();
                if (s.charAt(0) == 'E') st.pop();
                else if (s.charAt(0) == 'F') {
                    String name = next(); func.put(name, new pair(1, 0)); st.push(name);
                } else if (s.charAt(0) == 'C') {
                    String name = next(); pair t1 = func.get(st.peek()), t2 = func.get(name);
                    func.put(st.peek(), new pair(t1.m * t2.m % mod, (t1.m * t2.b + t1.b)%mod));
                } else if (s.charAt(0) == 'A') {
                    int x = readInt(); pair t1 = func.get(st.peek());
                    func.put(st.peek(), new pair(t1.m, (t1.m+x)%mod));
                } else if (s.charAt(0) == 'S') {
                    int x = readInt(); pair t1 = func.get(st.peek());
                    func.put(st.peek(), new pair(t1.m, (t1.m - x + mod) % mod));
                } else if (s.charAt(0) == 'M') {
                    int x = readInt(); pair t1 = func.get(st.peek());
                    func.put(st.peek(), new pair(t1.m * x % mod, (t1.m * x) % mod));
                }
            }
            System.out.println(func.get("main").b);
        }
    }

    static class pair {
        long m, b;
        pair(long m0, long b0) { m=m0; b = b0; }
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
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
