package Seasonal;

import java.util.*;
import java.io.*;

public class CatGirls {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), pos = 1;
        long W = readLong(), p, c, dp[] = new long[N+1], cute[] = new long[N+1], pose[] = new long[N+1];
        for (int i = 0; i < N; i++) {
            char chr = readCharacter();
            if (chr == 'A') {
                p = readLong(); c = readLong();
                pose[pos] = pose[pos - 1] + p;
                cute[pos] = cute[pos - 1] + c;
                long width;
                int lft = 0, rit = pos, mid;
                while (lft <= rit) {
                    mid = (lft + rit) >> 1;
                    width = pose[pos] - pose[mid];
                    if (width <= W) rit = mid - 1;
                    else lft = mid + 1;
                }
                dp[pos] = Math.max(dp[pos-1], cute[pos] - cute[lft]);
                System.out.println(dp[pos]); pos ++;
            } else pos --;
        }
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
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
}
