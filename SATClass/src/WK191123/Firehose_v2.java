package WK191123;

import java.util.*;

public class Firehose_v2 {
    static int H, K;
    static int[] arr;

    public static void main(String[] args) {
        init();
        run();
    }

    static void run(){
        int min = 0, max = 500000;
        while (min < max) {
            int mid = (min+max)>>1;
            int num = findNumHydrant(mid);
            if (K >= num)
                max = mid;
            else
                min = mid + 1;
        }
        System.out.println(min);
    }

    static int findNumHydrant(int len){
        int min = Integer.MAX_VALUE;
        for (int start = 0; start < H; start++){ //start = starting index
            int tmp = 1, curr = start; //curr = current location
            for (int i = curr; i < H + start; i++) {
                if (arr[i] - arr[curr] > len * 2){
                    curr = i;
                    tmp++;
                }
            }
            if (min > tmp)
                min = tmp;
        }
        return min;
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        arr = new int[H * 2];
        for (int i = 0; i < H; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr, 0, H);
        for (int i = 0; i < H; i++)
            arr[i + H] = arr[i] + 1000000;
        K = sc.nextInt();
    }
}