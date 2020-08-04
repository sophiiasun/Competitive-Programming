package CCC;

import java.util.*;
import java.io.*;

public class CCO00_Subsets {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static HashMap<Character, ArrayList<Character>> map = new HashMap<>();
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int n = readInt();
        char[] in;
        for (int i = 0; i < n; i++) {
            in = readLine().toCharArray();
            if (!map.containsKey(in[0])) map.put(in[0], new ArrayList<>());
            map.get(in[0]).add(in[11]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : map.keySet()) {
            doDFS(c);
            sb.append(c + " = {");
            for (char cc : set)
                sb.append(cc + ", ");
            sb.setLength(sb.length()-2);
            sb.append("}");
            System.out.println(sb);
            set.clear(); sb.delete(0, sb.length());
        }
    }

    static void doDFS(char c) {
        if (c >= 'a' && c <= 'z') { set.add(c); return; }
        if (!map.containsKey(c)) return;
        for (char chr : map.get(c)) {
            doDFS(chr);
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
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
