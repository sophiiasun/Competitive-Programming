package Y2005;

import java.util.*;

public class S05Q1_SnowCalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[10];
        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            String in = sc.next();
            for (int j = 0; j < 10; j++) {
                char tmp = in.charAt(j);
                if (tmp == '-') {
                    in = in.substring(1);
                    j--;
                }
                else if (tmp == 'A' || tmp == 'B' || tmp == 'C') arr[j] = 2;
                else if (tmp == 'D' || tmp == 'E' || tmp == 'F') arr[j] = 3;
                else if (tmp == 'G' || tmp == 'H' || tmp == 'I') arr[j] = 4;
                else if (tmp == 'J' || tmp == 'K' || tmp == 'L') arr[j] = 5;
                else if (tmp == 'M' || tmp == 'N' || tmp == 'O') arr[j] = 6;
                else if (tmp == 'P' || tmp == 'Q' || tmp == 'R' || tmp == 'S') arr[j] = 7;
                else if (tmp == 'T' || tmp == 'U' || tmp == 'V') arr[j] = 8;
                else if (tmp == 'W' || tmp == 'X' || tmp == 'Y' || tmp == 'Z') arr[j] = 9;
                else arr[j] = Character.getNumericValue(tmp);
            }
            for (int j = 0; j < 10; j++) {
                if (j == 3 || j == 6)
                    sb.append("-");
                sb.append(arr[j]);
            }
            System.out.println(sb);
        }
    }
}
