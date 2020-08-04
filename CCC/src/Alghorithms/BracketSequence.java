package Alghorithms;

import java.io.*;
import java.util.*;

/* Given n, how many different sequences of n valid brackets can be formed?
 *
 * E.g. n == 3:
 * ["()()()", "(())()", "()(())", "(()())", "((()))"]
 * Answer: 5
 */

public class BracketSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n;
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        n = readInt();
        run(0, 0, "");
        System.out.println(counter);
    }

    static void run (int total, int open, String seq) {
        if (total == n && open == 0) { // three open brackets and none are open
            System.out.println(seq); counter++; return;
        }
        if (open > 0) {
            run (total, open-1, seq + ")");
        }
        if (total < n) {
            run (total + 1, open+1, seq + "(");
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
}
