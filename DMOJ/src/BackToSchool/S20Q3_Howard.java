package CCC.Y2020;

import java.io.*;
import java.util.*;

public class S20Q3_Howard {

    public static void main(String[] args) throws IOException {
        String N = br.readLine(), H = br.readLine();
        int nl = N.length(), hl = H.length();

        if (nl > hl) { System.out.println(0); return; } // Needle length longer than hay length

        int[] stat = new int[26];
        for (int i = 0; i < nl; i++) stat[N.charAt(i) - 'a'] += 1; // Needle freq arr

        long[] h = new long[hl];
        int[] stat2 = new int[26];
        long p = 1, s = 31;

        for (int i = 0; i < nl; i++) {
            p *= s;
            char ch = H.charAt(i);

            if (i == 0) h[i] = ch - 'a' + 1;
            else h[i] = h[i - 1] * s + (ch - 'a' + 1);

            stat2[ch - 'a'] += 1;
        }

        HashSet<Long> result = new HashSet<>();
        if (Arrays.equals(stat, stat2)) {
            result.add(h[nl - 1]);
        }

        for (int i = nl; i < hl; i++) {
            char ch = H.charAt(i);
            stat2[ch - 'a'] += 1;

            h[i] = h[i - 1] * s + (ch - 'a' + 1);

            char ch2 = H.charAt(i - nl);
            stat2[ch2 - 'a'] -= 1;
            if (Arrays.equals(stat, stat2)) {
                result.add(h[i] - h[i - nl] * p);
            }
        }

        System.out.println(result.size());
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
}
