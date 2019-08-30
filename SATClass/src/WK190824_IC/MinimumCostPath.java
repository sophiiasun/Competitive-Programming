package WK190824_IC;

import java.util.*;

public class MinimumCostPath {

    class  ReturnObject {
        int val1;
        String var2;
    }

    private static Scanner sc = new Scanner(System.in);
    private static int c = sc.nextInt();
    private static int r = sc.nextInt();
    private static int[][] arr = new int[c][r];
    private static int[][] cost = new int[c][r];

    public static void main(String[] args) {
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {

            }
        }

    }

    private static ReturnObject func1() {
        ReturnObject obj = new ReturnObject();
        obj.val1 = 6;
        obj.var2 = "h";
        return obj;
    }

}
