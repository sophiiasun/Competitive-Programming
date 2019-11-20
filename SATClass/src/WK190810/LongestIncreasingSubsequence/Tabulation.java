package WK190810.LongestIncreasingSubsequence;

import java.util.*;

public class Tabulation {

    private static int[] aCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        aCnt = new int[N];
        Arrays.fill(aCnt, 1);
        for(int i = 0; i < N; i++)
            input[i] = sc.nextInt();
        double time = System.nanoTime();
        for(int i = 0; i < N; i++) {
            if(i == 0) aCnt[i] = 1;
            else {
                aCnt[i] = getMax(input, i);
            }
        }
        System.out.println(Arrays.toString(aCnt));
        int out = 1;
        for(int i = 0; i < N; i++) {
            if(aCnt[i] > out)
                out = aCnt[i];
        }
        System.out.println(out);
        System.out.println(System.nanoTime() - time);
    }

    private static int getMax(int[] aList, int N) {
        int iRet = 1;
        for(int i = 0; i < N ; i++) {
            if(aCnt[i] + 1 > iRet && aList[i] < aList[N])
                iRet = aCnt[i] + 1;
        }
        return iRet;
    }
}