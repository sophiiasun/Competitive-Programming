package CCO.Y2019;

import java.util.*;
import java.io.*;

public class P1_HumanError {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R, C, J, D, mask, p[] = new int[14], dir[][] = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}, err[] = new int[14];
    static double dp[][] = new double[2][1600000];

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt();
        for (int i = 0; i < R; i++) {
            String in = readLine();
            for (int j = 0; j < C; j++) {
                int tmp = in.charAt(j) == 'J' ? 1 : (in.charAt(j) == 'D' ? 2 : 0);
                mask = mask*3 + tmp;
            }
        }
        J = readInt(); D = readInt();
        System.out.println(run(0, mask));
    }

    static void run2(int mask, int g[]) {
        int tmp = R*C - 1;
        for (int i = R-1; i >= 0; i--) {
            for (int j = C-1; j >= 0; j--) {
                g[tmp--] = mask % 3; mask /= 3;
            }
        }
    }

    static double run(int curr, int mask) {
        if (dp[curr][mask] >= 0) return dp[0][mask];
        int g[] = new int[14]; double ret = 0.0;
        ArrayList<Double> list = new ArrayList<>();
        run2(mask, g);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int next = i * C + j;
                if (g[next] != curr + 1) continue;
                for (int k = 0; k < 4; k++) {
                    int tr = i + dir[k][0], tc = j + dir[k][1], tmp = tr*C + tc;
                    if (tr >= 0 && tr < R && tc >= 0 && tc < C && g[tmp] != 0) {
//                        int nMask = mask - g[next]*p - g[tmp]*p + g[tmp]*p;
//                        list.add(1 - run(!curr, nMask));
                    }
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        int size = Math.min(list.size(), err[curr]);
        if (size == 0) return dp[curr][mask] = 0.0;
        for (int i = 0; i < size; i++) ret += list.get(i);
        return dp[curr][mask] = ret / size;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
