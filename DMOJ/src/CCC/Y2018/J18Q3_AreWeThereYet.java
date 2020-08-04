package CCC.Y2018;

import java.util.*;

public class J18Q3_AreWeThereYet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        arr[0] = 0;
        for (int i = 1; i < 5; i++)
            arr[i] = sc.nextInt() + arr[i-1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++){
            if (i != 0)
                sb.append("\n");
            for (int j = 0; j < 5; j++) {
                if (j != 0)
                    sb.append(" ");
                sb.append(Math.abs(arr[i] - arr[j]));
            }
        }
        System.out.println(sb);
    }
}
