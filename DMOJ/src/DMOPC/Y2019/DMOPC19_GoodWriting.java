package DMOPC.Y2019;

import java.util.*;
import java.io.*;

public class DMOPC19_GoodWriting {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static HashMap<Integer, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        int q = readInt(), n, k;
        for (int qq = 0; qq < q; qq++) {
            n = readInt(); k = readInt() - 1;
            String ans = run(n, k);
            if (ans.length() < k) System.out.println(".");
            else System.out.println(ans.charAt(k));
            sb.delete(0, sb.length());
        }
    }

    static String run(int n, int k) {
        if (map.containsKey(n)) return map.get(n);
        if (sb.length() >= k) {
            return sb.toString();
        }
        sb.append("Good writing is good " + run(n-1, k) + " writing is good " + map.get(n-1) + " is good writing.");
        map.put(n-1, sb.toString());
        return map.get(n-1);
    }

    static void init() {
        map.put(0, "Good writing is good writing is good writing.");
        map.put(1, "Good writing is good Good writing is good writing is good writing. writing is good Good writing is good writing is good writing. is good writing.");
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
