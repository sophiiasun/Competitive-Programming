import java.util.*;
import java.io.*;

public class RainfallStorageII {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), h[] = new int[n+2], pmax[] = new int[n+2], smax[] = new int[n+2];
        for (int i = 1; i <= n; i++) {
            h[i] = readInt(); pmax[i] = Math.max(h[i], pmax[i-1]);
        }
        long ans = 0;
        for (int i = n; i >= 1; i--) {
            smax[i] = Math.max(smax[i+1], h[i]);
            ans += Math.min(pmax[i], smax[i]) - h[i];
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
