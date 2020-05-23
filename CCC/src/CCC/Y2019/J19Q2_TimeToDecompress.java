package CCC.Y2019;

import java.util.Scanner;

public class J19Q2_TimeToDecompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            char chr = sc.next().charAt(0);
            String out = "";
            for (int j = 0; j < M; j++)
                out += chr;
            System.out.println(out);
        }
    }
}
