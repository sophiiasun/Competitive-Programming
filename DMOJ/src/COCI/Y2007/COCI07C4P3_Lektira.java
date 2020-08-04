package COCI.Y2007;

import java.util.*;
import java.io.*;

public class COCI07C4P3_Lektira {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static char[] in;

    public static void main(String[] args) throws IOException {
        in = readLine().toCharArray(); int pos = -1, max = 0, cnt = 0, cut[] = new int[2];

        for (int t = 0; t < 2; t++) {
            char low = 'z' + 1;
            for (int i = pos + 1; i < in.length-t; i++) {
                if (in[i] < low) { low = in[i]; pos = i; cnt = 1; }
                else if (in[i] == low && pos == i-1) {
                    cnt++;
                    if (cnt > max) { max = cnt; pos = i; }
                }
            }
            cut[t] = pos;
        }
        flip(0, cut[0]);
        flip(cut[0]+1, cut[1]);
        flip(cut[1]+1, in.length-1);
        for (int i = 0; i < in.length; i++) System.out.print(in[i]);
        System.out.println();
    }

    static void flip (int pf, int pb) {
        while (pf < pb) {
            char t = in[pf]; in[pf] = in[pb]; in[pb] = t;
            pf++; pb--;
        }
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
