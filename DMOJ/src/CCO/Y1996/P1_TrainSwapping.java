package CCO.Y1996;

import java.util.*;

public class P1_TrainSwapping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr;
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            arr = new int[M];
            for (int j = 0; j < M; j++)
                arr[j] = sc.nextInt();
            int out = BubbleSort(M, arr);
            System.out.println("Optimal train swapping takes " + out + " swaps.");
        }
    }
    static int BubbleSort(int M, int[] arr){
        boolean sorted;
        int cnt = 0, tmp;
        do {
            sorted = true;
            for (int i = 0; i < M - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    cnt++;
                    sorted = false;
                }
            }
        } while (!sorted);
        return cnt;
    }
}
