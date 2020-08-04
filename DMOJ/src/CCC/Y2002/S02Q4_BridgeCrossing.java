package CCC.Y2002;

import java.util.*;
import java.io.*;

public class S02Q4_BridgeCrossing {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int M = readInt(), Q = readInt(), a[] = new int[Q+1], dp[] = new int[Q+1]; String[] s = new String[Q+1];
        int[] arr = new int[Q+1]; Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= Q; i++) { s[i] = next(); a[i] = readInt(); }
        dp[0] = 0; arr[0] = -1;
        for (int i = 1; i <= Q; i++) {
            int lar = 0;
            for (int j = i; j > Math.max(0, i-M); j--) {
                lar = Math.max(lar, a[j]);
                if (dp[i] > dp[j-1] + lar) {
                    dp[i] = dp[j-1] + lar; arr[i] = i-j;
                }
            }
        }
        System.out.println("Total Time: " + dp[Q]);
        ArrayList<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int p = Q;
        for (int i = Q; i > 0; i -= arr[i] + 1) {
            out.add("\n");
            for (int j = arr[i]; j >= 0; j--) {
                out.add(s[p--]);
            }
        }

//        for (int i = 1; i <= Q; i++) {
//            if (arr[i] == 0) out.add("\n");
//            out.add(s[i]);
//        } out.add("\n");

//        while (arr[Q] != -1) {
//            for (int i = Q - arr[Q] + 1; i <= Q; i++) { out.add(s[p]); p++; }
//            out.add("\n");
//        }

        for (int i = out.size()-1; i > 0; i--) {
            if (out.get(i).equals("\n")) {
                sb.setLength(sb.length()-1);
                System.out.println(sb); sb.delete(0, sb.length());
            } else {
                sb.append(out.get(i) + " ");
            }
        }
        System.out.println(sb);

//        for (String str : out) {
//            if (str.equals("\n")) {
//                sb.setLength(sb.length()-1);
//                System.out.println(sb); sb.delete(0, sb.length());
//            } else {
//                sb.append(str + " ");
//            }
//        }
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
