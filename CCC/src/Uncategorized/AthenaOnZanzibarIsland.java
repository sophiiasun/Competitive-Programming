package Uncategorized;

import java.util.*;

public class AthenaOnZanzibarIsland {
    public static void main(String[] args) {
        version2();
    }

    static void version1(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int A = 0, B = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int tmp = Math.abs(arr[i]+arr[j]);
                if (tmp < min) {
                    min = tmp;
                    A = i;
                    B = j;
                    if (min == 0)
                        break;
                }
            }
            if (min == 0)
                break;
        }
        System.out.println(min);
        System.out.println(A+1 + " " + (B+1));
    }

    static void version2(){

    }
}
