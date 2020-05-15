import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class template {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String in = next();
            for (int j = 0; j < N; j++) {
                if (in.charAt(j) != '.') list.add(new int[]{i, j});
            }
        }
        int cnt = 0, tmp1, tmp2;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    tmp1 = Math.abs(list.get(i)[1] - list.get(j)[1]); tmp2 = Math.abs(list.get(i)[0] - list.get(j)[0]);
                    double dis1 = Math.sqrt(tmp1*tmp1 + tmp2*tmp2);
                    tmp1 = Math.abs(list.get(i)[1] - list.get(k)[1]); tmp2 = Math.abs(list.get(i)[0] - list.get(k)[0]);
                    double dis2 = Math.sqrt(tmp1*tmp1 + tmp2*tmp2);
                    tmp1 = Math.abs(list.get(k)[1] - list.get(j)[1]); tmp2 = Math.abs(list.get(k)[0] - list.get(j)[0]);
                    double dis3 = Math.sqrt(tmp1*tmp1 + tmp2*tmp2);
                    double s = (dis1+dis2+dis3) / 2; s = Math.sqrt(s*(s-dis1)*(s-dis2)*(s-dis3));
                    if (s < 0.000000001)
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
