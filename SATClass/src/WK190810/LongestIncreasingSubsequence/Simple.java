package WK190810.LongestIncreasingSubsequence;

import java.util.*;

public class Simple {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        double time = System.nanoTime();
        int out = getLIS(input, N - 1);
        System.out.println(out);
        System.out.println(System.nanoTime() - time);
    }

    private static int getLIS(int[] aList, int N) {
        int iRet = 1;
        for(int i = 0; i < N; i++) {
            int iC = getLIS(aList, i);
            if(aList[i] < aList[N] && iC + 1 > iRet)
                iRet = iC + 1;
        }
        return iRet;
    }

}
