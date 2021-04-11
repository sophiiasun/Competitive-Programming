package Applyby;

import java.io.*;
import java.util.*;

public class LoveLetter {
    public static void main(String[] args) throws IOException  {
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