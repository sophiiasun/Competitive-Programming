package WK191012;

import java.util.*;

public class QueenProblem {
    static int N;
    static int[][] arr;
    static int[][] data;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        data = new int[N][2];
        for (int i = 0; i < N; i++){
            init(i);
            run(0, 1);
        }
        System.out.println(cnt);
    }
    static void run (int iR, int iN) {
        if(iN == N){
            out();
            cnt++;
            return;
        }
        int nC = 0;
        int nR = 0;
        for(int i = 0; i < N; i++) {
            nC = i;
            nR = iR + 1;
            if(chk(nR, nC, iN)) { //returns true if usable
                data[iN][0] = nR;
                data[iN][1] = nC;
                arr[nR][nC] = 1;
                run(nR, iN + 1);
                arr[nR][nC] = 0;
            }
        }
    }
    static boolean chk(int iR, int iC, int iN) { //input coordinates of new queen
        int cnt = 0;
        while (cnt < iN) {
            int R = data[cnt][0];
            int C = data[cnt][1];
            if (iC == C) return false;
            else if (Math.abs(iR - R) == Math.abs(iC - C)) return false;
            cnt++;
        }
        return true;
    }
    static void out(){
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < 8;r ++) {
            for(int c= 0;c<8;c++){
                if (c!=0)
                    sb.append(" ");
                sb.append(arr[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void init(int i) {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                arr[r][c] = 0;
                if (c < 2)
                    data[r][c] = -1;
            }
        }
        arr[0][i] = 1;
        data[0][0] = 0;
        data[0][1] = i;
    }
}
