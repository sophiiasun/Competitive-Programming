package DMOPC.Y2019.C7;

import java.util.*;
import java.io.*;

public class DMOPC19_Hydrocarbons {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt(), c = readInt(), d = readInt();
        if (b==0 && a<c-1) {
            System.out.println("invalid"); return;
        }
        if (b>0 && a<c) {
            System.out.println("invalid"); return;
        }
        int CC = 2*a + 4*b + 6*c;
        if (4*(a+b+c+1)-CC != d) {
            System.out.println("invalid");
        } else {
            System.out.println("C" + (a+b+c+1) + "H" + d);
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
