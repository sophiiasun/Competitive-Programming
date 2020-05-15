package Miscellaneous.DMOPC;

import java.util.*;
import java.io.*;

public class DMOPC19_Hydrocarbons {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt(), c = readInt(), d = readInt();
        int CC = 0, HH = 0;
        CC += a*4; CC += b*8; CC += c*12; CC += 2*d; HH += 2*d;
        if (CC%8==0)
            if (a>0 || b>0 || c>0) {
                if (CC / 8 > 1) System.out.println("C" + (CC / 8) + "H" + (HH / 2));
                else System.out.println("invalid");
            } else System.out.println("C" + (CC / 8) + "H" + (HH / 2));
        else System.out.println("invalid");
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
