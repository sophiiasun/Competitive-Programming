package BackToSchool;

import java.util.*;
import java.io.*;

public class BTS17_WetMud {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), J = readInt();
        if (N >= J) {
            int[][] dry = new int[M][2];
            for (int i = 0; i < M; i++) {
                dry[i][0] = readInt();
                dry[i][1] = readInt();
            }
            Arrays.sort(dry, (int[] a, int[] b) -> a[1] - b[1]);
            boolean[] mud = new boolean[N + 2];
            Arrays.fill(mud, true);
            mud[0] = false;
            mud[N + 1] = false;
            int time = 0;
            int pos = 0;
            for (int i = 0; i < M; i++) {
                if (dry[i][0] > pos) {
                    time = dry[i][1];
                    mud[dry[i][0]] = false;
                    boolean jump;
                    do {
                        jump = false;
                        if (pos + J > N) {
                            System.out.println(time); System.exit(0);
                        }
                        for (int j = J; j > 0; j--) {
                            if (!mud[pos + j]) {
                                pos += j; jump = true; break;
                            }
                        }
                    } while (jump);
                }
            }
            System.out.println(-1);
        } else System.out.println(0);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
