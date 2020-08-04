package CCC.Y2007;

import java.util.*;
import java.io.*;

public class S07Q3_Friends {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        HashMap<Integer, F> map = new HashMap<>();
        for (int i = 0; i < N; i++) map.put(readInt(), new F(readInt(), -1));
        int start = readInt(), end = readInt();
        int prev, curr;
        while (start != 0 && end != 0) {
            boolean reached = false;
            prev = start; curr = map.get(start).f;
            while (true) {
                if (map.get(curr).d == -1) {
                    map.get(curr).d = map.get(prev).d + 1;
                    if (curr == end) { reached = true; break; }
                    prev = curr; curr = map.get(curr).f;
                } else break;
            }
            if (reached) System.out.println("Yes " + map.get(curr).d);
            else System.out.println("No");
            Set<Integer> list = map.keySet();
            for (int i : list) map.get(i).d = -1; // Clear distance
            start = readInt(); end = readInt();
        }
    }

    static class F {
        int f, d;
        F (int friend, int distance) { f = friend; d = distance; }
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
