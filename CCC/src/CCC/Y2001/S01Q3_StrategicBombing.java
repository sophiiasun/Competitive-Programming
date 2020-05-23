package CCC.Y2001;

import java.util.*;
import java.io.*;

public class S01Q3_StrategicBombing {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException { // A = 65, Z = 90
        arr = new ArrayList[26];
        for (int i = 0; i < 26; i++) arr[i] = new ArrayList<>();
        String in = next();
        while (in.charAt(0) != '*') {
            arr[in.charAt(0)-65].add(in.charAt(1)-65); arr[in.charAt(1)-65].add(in.charAt(0)-65);
            in = next();
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                if (arr[i].get(j)>i && !doBFS(i, arr[i].get(j))) {
                    count++; System.out.println((char)(i+65) + "" + (char)(arr[i].get(j)+65));
                }
            }
        }
        System.out.println("There are " + count + " disconnecting roads.");
    }

    static boolean doBFS(int a, int b) {
        boolean[] vis = new boolean[26];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            vis[curr] = true;
            for (int i : arr[curr]) {
                if ((curr!=a || i!=b) && (curr!=b || i!=a)) {
                    if (i == 1) return true;
                    if (!vis[i]) queue.add(i);
                }
            }
        }
        return false;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
