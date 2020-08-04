package CEOI;

import java.util.*;
import java.io.*;

public class CEOI18P5_Toys {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n;
    static SortedSet<Integer> list = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        n = readInt();
        run(n, 2, 0);
        System.out.println(list.size());
        for (int i : list) System.out.print(i + " ");
        System.out.println();
    }

    static void run(int curr, int fact, int sum) {
        list.add(sum + curr - 1);
        for (int i = fact; i*i <= curr; i++) {
            if (curr % i == 0) run(curr/i, i, sum + i - 1);
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
