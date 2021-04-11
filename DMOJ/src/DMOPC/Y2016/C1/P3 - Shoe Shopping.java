import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(); double a[] = new double[N+1], dp[] = new double[N+1];
        Arrays.fill(dp, 2000000000);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            a[i] = readInt();
            dp[i] = dp[i-1] + a[i];
            if (i - 3 >= 0) dp[i] = Math.min(dp[i], dp[i-3] + c3(a[i], a[i-1], a[i-2]));
            if (i - 2 >= 0) dp[i] = Math.min(dp[i], dp[i-2] + c2(a[i], a[i-1]));
        }
        long ans = (long)dp[N]; dp[N] -= ans; int dec = (int)(dp[N] / 0.1);
        System.out.println(ans + "." + dec);
    }

    static double c3 (double a, double b, double c) {
        return a + b + c - Math.min(Math.min(a, b), c);
    }

    static double c2 (double a, double b) {
        return Math.max(a, b) + (Math.min(a,b) / 2.0);
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