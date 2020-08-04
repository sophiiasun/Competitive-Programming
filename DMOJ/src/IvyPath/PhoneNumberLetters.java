package IvyPath;

import java.util.*;
import java.io.*;

/* 1: N/A
 * 2: a, b, c
 * 3: d, e, f
 * 4: g, h, i
 * 5: j, k, l
 * 6: m, n, o
 * 7: p, q, r, s
 * 8: t, u, v
 * 9: w, x, y, z
 */

public class PhoneNumberLetters {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static String in;
    static int counter = 0;
    static HashMap<Character, char[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        in = next();
        map.put('2', new char[]{'a', 'b', 'c'}); map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'}); map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'}); map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'}); map.put('9', new char[]{'w', 'x', 'y', 'z'});
        run("", 0);
        System.out.println(counter);
    }

    static void run (String seq, int index) {
        if (seq.length() == in.length()) {
            System.out.println(seq); counter++; return;
        }
        for (char c : map.get(in.charAt(index))) {
            run (seq + c, index + 1);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
