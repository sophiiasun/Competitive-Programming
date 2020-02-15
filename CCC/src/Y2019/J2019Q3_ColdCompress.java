package Y2019;

import java.util.Scanner;

public class J2019Q3_ColdCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++){
            String in = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < in.length();) {
                int counter = 1;
                char chr = in.charAt(0);
                while (j + counter < N && in.charAt(j + counter) == chr)
                    counter++;
                sb.append(counter + " " + chr + " ");
                j += counter;
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
