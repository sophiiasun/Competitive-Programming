import java.util.*;
import java.io.*;

public class IOI02_BatchScheduling {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int[] dp, sumT;

    public static void main(String[] args) throws IOException {
        int N = readInt(), S = readInt();
        int[] T = new int[N + 1], F = new int[N + 1], sumF = new int[N+1]; dp = new int[N + 1]; sumT = new int[N + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) { T[i] = readInt(); F[i] = readInt(); } // input
        for (int i = N-1; i >= 0; i--) { // psa
            sumT[i] = sumT[i+1] + T[i]; sumF[i] = sumF[i+1] + F[i];
        }
        deque.add(N);
        for (int i = N-1; i >= 0; i--) {
            while (deque.size() >= 2) {
                int first = deque.pollFirst(), second = deque.peekFirst();
                if (calc(first, second) >= (double)sumF[i]) { deque.addFirst(first); break; }
            }
            int tmp = deque.peekFirst();
            dp[i] = dp[tmp] + (S + sumT[i] - sumT[tmp]) * sumF[i];
            while (deque.size() >= 2) {
                int first = deque.pollLast(), second = deque.peekLast();
                if (calc(second, first) <= calc(first, i)) { deque.addLast(first); break; }
            }
            deque.addLast(i);
        }
        System.out.println(dp[0]);
    }

    static double calc(int a, int b) {
        return ((double)dp[a] - (double)dp[b]) / ((double)sumT[a] - (double)sumT[b]);
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
