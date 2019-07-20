package WK190622;

import java.util.*;

public class CitiesAndStates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(N);
        int[][] cord = new int[N][2];
        int[] dis = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(j==0 || j==1) {
                    cord[i][j] = sc.nextInt();
                } else {
                    dis[i] = sc.nextInt();
                }
            }
        }
    }
}
