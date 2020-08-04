package WK191005;

import java.util.*;

public class Lemonade {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        init();
        run();
    }
    static void run() {
        int cnt = 0; //counts the number of cows already in line
        for (int i = 0; i < N; i++) {
            if (cnt <= arr[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
    }
}
