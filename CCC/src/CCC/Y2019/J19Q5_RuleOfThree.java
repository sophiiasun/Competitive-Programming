package CCC.Y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J19Q5_RuleOfThree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static String[][] arr = new String[3][];
    static String[] org;
    static int COUNT;

    public static void main(String[] args) throws IOException {
        arr[0][0] = next(); arr[0][1] = next();
        arr[1][0] = next(); arr[1][1] = next();
        arr[2][0] = next(); arr[2][1] = next();
        COUNT = readInt(); org[0] = next(); org[1] = next();
    }

//    static String run (int count, String s) {
//        if (count == COUNT) return s;
//        for (int i = 0; i < 3; i++) {
//
//        }
//    }

    static class Rule {
        String s, e;
        Rule (String ps, String pe) { s = ps; e = pe; }
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
    static String readLine () throws IOException {
        return br.readLine().trim();
    }

}
