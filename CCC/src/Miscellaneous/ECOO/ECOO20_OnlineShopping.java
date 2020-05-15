package Miscellaneous.ECOO;

import java.util.*;
import java.io.*;

public class ECOO20_OnlineShopping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt(), N, M, K, D, cost, curr[]; String S;
        for (int t = 0; t < T; t++) {
            N = readInt(); HashMap<String, PriorityQueue<int[]>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                M = readInt();
                for (int j = 0; j < M; j++) {
                    S = next();
                    if (!map.containsKey(S)) map.put(S, new PriorityQueue<>((int[]a, int[]b)-> a[0]-b[0]));
                    map.get(S).add(new int[]{readInt(), readInt()});
                }
            } K = readInt(); cost = 0;
            for (int i = 0; i < K; i++) {
                S = next(); D = readInt();
                while (!map.get(S).isEmpty() && D > 0) {
                    curr = map.get(S).poll();
                    if (curr[1] >= D) {
                        cost += D * curr[0]; D = 0;
                    } else {
                        cost += curr[0] * curr[1]; D -= curr[1];
                    }
                }
            }
            System.out.println(cost);
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
