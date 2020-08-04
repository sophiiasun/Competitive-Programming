package COCI.Y2006;

import java.util.*;
import java.io.*;

public class COCI06_Stol {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int RR = readInt(), CC = readInt(), psa[][] = new int[RR+1][CC+1];
        for (int i = 1; i <= RR; i++) {
            String in = " " + readLine();
            for (int j = 1; j <= CC; j++) { // '.' = 1, 'X' = 0
                psa[i][j] = psa[i][j-1];
                if (in.charAt(j) == 'X') psa[i][j]++;
            }
        }

        int ans = 0, cnt;
        for (int c1 = 1; c1 <= CC; c1++) {
            for (int c2 = c1; c2 <= CC; c2++) {
                cnt = 0;
                for (int r = 1; r <= RR; r++) {
                    if (psa[r][c2] - psa[r][c1-1] == 0)
                        cnt++;
                    else if (cnt > 0) { ans = Math.max(ans, (cnt + c2-c1 + 1)<<1); cnt = 0; }
                }
                if (cnt > 0) ans = Math.max(ans, (cnt + c2-c1 + 1)<<1);
            }
        }

        System.out.println(ans-1);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
