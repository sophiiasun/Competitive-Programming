package Olympiads;

import java.util.*;
import java.io.*;

public class BobsWeekend {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        Task[] arr = new Task[N];
        for (int i = 0; i < N; i++) arr[i] = new Task(readInt(), readInt());
        Arrays.sort(arr);
        int T = Integer.MAX_VALUE;
        for (int i = 0; i < N && T >= 0; i++) {
            T = Math.min(T, arr[i].s);
            T -= arr[i].t;
        }
        System.out.println(T>=0 ? T : -1);
    }

    static class Task implements Comparable<Task> {
        int t, s;
        Task (int pt, int ps) { t = pt; s = ps; }
        public int compareTo (Task tast) { return tast.s - s; }
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
