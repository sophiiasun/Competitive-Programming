import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, mod, cnt;
    static long num;
    static String s;
    static HashMap<String, F> map;

    public static void main(String[] args) throws IOException {
        N = readInt(); mod = (int)1e9+7;
        for (int n = 0; n < N; n++) {
            map = new HashMap<>(); num = 0; M = readInt(); cnt=0;
            for (cnt = 0; cnt < M; cnt++) {
                s = next();
                if (s.charAt(0) == 'A') num = (num + readInt())%mod;
                else if (s.charAt(0) == 'S') num = (num - readInt() + mod)%mod;
                else if (s.charAt(0) == 'M') num = (num * readInt())%mod;
                else if (s.charAt(0) == 'F') getFunc(next());
                else if (s.charAt(0) == 'C') callFunc(next());
            }
            System.out.println(num);
        }
    }

    static void getFunc(String func) throws IOException {
        F f = new F(); map.put(func, f); s = next();
        while (s.charAt(0) != 'E') {
            if (s.charAt(0) == 'F') {
                getFunc(next());
            } else if (s.charAt(0) == 'C') {
                F c = map.get(next());
                f.m = (f.m * c.m) % mod;
                f.a = ((f.a * c.m) % mod + c.a) % mod;
            } else if (s.charAt(0) == 'A') {
                f.a = (f.a + readInt()) % mod;
            } else if (s.charAt(0) == 'S') {
                f.a = (f.a - readInt() + mod) % mod;
            } else if (s.charAt(0) == 'M') {
                int m = readInt();
                f.m = (f.m * m) % mod;
                f.a = (f.a * m) % mod;
            } s = next(); cnt++;
        } cnt++;
    }

    static void callFunc(String f) {
        F c = map.get(f);
        num = ((num * c.m) % mod + c.a) % mod;
    }

    static class F {
        long a = 0, m = 1;
        F () {}
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