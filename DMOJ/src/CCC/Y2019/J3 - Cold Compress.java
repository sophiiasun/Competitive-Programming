package CCC.Y2019;

import java.util.Scanner;

public class J19Q3_ColdCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++){
            String in = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < in.length();) {
                int counter = 1;
                char chr = in.charAt(j);
                while (j + counter < in.length() && in.charAt(j + counter) == chr)
                    counter++;
                sb.append(counter + " " + chr + " ");
                j += counter;
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
