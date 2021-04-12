import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        double TIME = System.currentTimeMillis();

        final int N = readInt(), M = readInt(); long A = readInt(), B = readInt(), C = readInt();
        int arr[] = new int[N+1]; long time[] = new long[N+1];
        for (int i = 1; i <= N; i++) arr[i] = readInt();
        Arrays.sort(arr); // sort array based on where soldiers are headed
        time[1] = A * (arr[1] - 1); // time[] stores the min time is takes for soldier i to travel to their destination
        for (int i = 2; i <= N; i++) { // find time required if all soldiers used Aurora
            if (arr[i] != arr[i-1]) time[i] = A * (arr[i] - arr[i-1]);
            time[i] += time[i-1] + C;
        }
        long t = 0, tb, tc, save = 0;
        boolean over = false;
        for (int i = 1; i <= N; i++) { // don't need to check N because arr[N] travels to M (Aurora def faster)
            if (!over) { // if soldier i should take Aurora, then soldier i -> soldier should all take Aurora
                time[i] -= t; // subtract time bc some soldiers used para-mail and don't gotta wait for them to get off Aurora
                tb = B * (arr[i] - 1); // time taken if soldier i took para-mail
                tc = C * (N - i); // time taken for remaining soldiers to get off of Aurora
                // if tb + time for remaining soldiers via Aurora <= tc + time[i] + time for remaining soldiers via Aurora
                // OR (SIMPLIFIED): if tb <= tc + time[i]
                if (tb <= tc + time[i]) {
                    t += C; time[i] = tb;
                } else {
                    over = true; // Everyone remaining should take Aurora
                    save = t * (N-i);
                }
            }
            time[i] += time[i-1];
        }
        System.out.println(time[N] - save);

        TIME = (System.currentTimeMillis() - TIME);
        if (TIME >= 600) System.out.println(TIME);
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