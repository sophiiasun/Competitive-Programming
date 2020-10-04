package UCC_Coding_Competition;

import java.util.*;
import java.io.*;

public class UCC20_PublicTransportation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int L = readInt(), A = readInt(), B = readInt(), N = readInt();
        ArrayList<Integer>[] arr = new ArrayList[L+1];
        for (int i = 1; i <= L; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) arr[readInt()].add(readInt());
        int[] dis = new int[L+1]; Arrays.fill(dis, -1); dis[A] = 0;
        Queue<Integer> queue = new LinkedList<>(); queue.add(A);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (i == B) {
                    System.out.println(dis[curr]+1); return;
                } else if (dis[i] == -1) {
                    dis[i] = dis[curr] + 1;
                    queue.add(i);
                }
            }
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
