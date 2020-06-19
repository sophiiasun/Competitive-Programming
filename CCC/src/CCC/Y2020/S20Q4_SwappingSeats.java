package CCC.Y2020;

import java.util.*;
import java.io.*;

public class S20Q4_SwappingSeats {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String in = next(); int n = in.length();
        int minA = Integer.MAX_VALUE, CA = 0, psa[] = new int[n<<1];
        if (in.charAt(0) != 'A') { psa[0] = 1; psa[n] = 1; }
        else CA++;
        for (int i = 1; i < n << 1; i++) { // Find how many non-A's there are
            psa[i] = psa[i-1];
            if (in.charAt(i%n) != 'A') psa[i]++;
            else CA++;
        }
        CA >>= 1;
        for (int i = 0; i < n; i++) {
            minA = Math.min(minA, Math.abs(psa[i + CA] - psa[i]));
        }
        System.out.println(minA);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
