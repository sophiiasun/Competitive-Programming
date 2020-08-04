import java.util.*;
import java.io.*;

// split sequence

public class IOI02_BatchScheduling {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, dq[], arr[][];
    static long psa[], dp[][];

    public static void main(String[] args) throws IOException {
        N = readInt(); K = readInt();
        for (int i = 1; i <= N; i++) { psa[i] = readInt() + psa[i-1]; }
        for (int i = 1; i <= K; i++) {
            int pf = 1, pb = 1;
            for (int j = 1; j <= N; j++) {
                while (pf < pb && calc(i, dq[pf], dq[pf+1]) >= psa[j] * (psa[dq[pf]] - psa[dq[pf+1]])) pf++;
                dp[i][j] = dp[i-1][dq[pf]] + psa[dq[pf]] * (psa[j] - psa[dq[pf]]);
                arr[i][j] = dq[pf]; //Store cut index
                while (pf < pb && calc2(i, dq[pb], dq[pb-1], dq[pb], j) >= calc2(i, j, dq[pb], dq[pb-1], dq[pb])) pb--;
                dq[++pb] = j;
            }
        }
//    cout<<endl;
        System.out.println(dp[K][N]);
        for (int i = N; K >= 0; i = arr[K--][i]) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static long calc2(int x, int y, int z, int i, int j) {
        return calc(x, y, z) * (psa[i] - psa[j]);
    }

    static long calc(int a, int b, int c) {
        return (dp[a][c] - dp[b][c] - psa[a]*psa[a] + psa[b]*psa[b]);
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
