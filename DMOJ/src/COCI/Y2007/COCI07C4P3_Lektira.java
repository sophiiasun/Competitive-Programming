package COCI.Y2007;

import java.util.*;
import java.io.*;

public class COCI07C4P3_Lektira {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static char[] in, tmp, ans;

    public static void main(String[] args) throws IOException {
        in = readLine().toCharArray(); int len = in.length;
        ans = Arrays.copyOf(in, len);

        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len-1; j++) {
                tmp = Arrays.copyOf(in, len);
                flip(0, i); flip(i+1, j); flip(j+1, len-1);
                if (comp(tmp,ans)) ans = Arrays.copyOf(tmp, len);
            }
        }

        for (int i = 0; i < in.length; i++) System.out.print(ans[i]);
        System.out.println();
    }

    static void flip (int pf, int pb) {
        while (pf < pb) {
            char t = tmp[pf]; tmp[pf] = tmp[pb]; tmp[pb] = t;
            pf++; pb--;
        }
    }
    static boolean comp (char[] a, char[] b) {
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] < b[i]) return true;
            else if (a[i] > b[i]) return false;
        }
        return a.length < b.length;
    }

    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
