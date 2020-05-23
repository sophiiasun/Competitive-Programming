package Applyby;

import java.io.*;
import java.util.*;

public class LoveLetter {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
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

    public static void main(String[] args) throws IOException  {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), L = sc.nextInt() % 26;
        String S = sc.nextLine();
        while (S.equals("")) S = sc.nextLine();
        for (int i = 0; i < S.length(); i++)  {
            char c = S.charAt(i);
            if (c != ' ') {
                if (S.charAt(i) + L <= 122) System.out.print((char)(S.charAt(i) + L));
                else System.out.print((char)(S.charAt(i) + L - 26));
            } else System.out.print(c);
        }
    }
}