package CCC.Y2015;

import java.util.*;
import java.io.*;

public class S15Q3_Gates {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int G = readInt(), P = readInt(), ans = 0; boolean[] arr = new boolean[G+1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= G; i++) list.add(i);
        for (int i = 0; i < P && list.size() > 0; i++) {
            int p = readInt(), cnt = 0;
            if (p < list.get(0)) break;
            while (list.get(cnt+1) <= p && cnt + 2 < list.size())
                cnt++;
            list.remove(cnt);
            ans++;
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
