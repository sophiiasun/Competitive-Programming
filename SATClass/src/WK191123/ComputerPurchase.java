package WK191123;

import java.util.*;

public class ComputerPurchase {
    static int N;
    static String[][] arr;
    public static void main(String[] args) {
        init();
        System.out.println(run());
    }
    static String run(){
        int max = 0;
        String str = "";
        for (int i = 0; i < N; i++) {
            int tmp = (Integer.parseInt(arr[i][1]) << 1) + (Integer.parseInt(arr[i][2]) * 3) + Integer.parseInt(arr[i][3]);
            if (tmp > max) {
                max = tmp;
                str = arr[i][0];
            } else if (tmp == max) {
                if(arr[i][0].charAt(0) < str.charAt(0))
                    str = arr[i][0];
            }
        }
        return str;
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new String[N][4];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextLine().split(" ");
        }
    }
}
