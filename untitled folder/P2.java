import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int M = readInt(), N = readInt(), K = readInt(), ans=0, p;
        boolean r[] = new boolean[M+1], c[] = new boolean[N+1];
        char opt;
        for (int i = 0; i < K; i++) {
            opt = readCharacter(); p = readInt();
            if (opt == 'R') r[p] = !r[p];
            else c[p] = !c[p];
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                ans += ((r[i] == true || c[j] == true) && !(r[i] == true && c[j] == true) ? 1 : 0);
            }
        }
        System.out.println(ans);
    }


    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}