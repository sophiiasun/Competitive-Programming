package Y2018;

import java.util.Scanner;

public class J18Q4_Sunflowers { //Same question as S2

    static Scanner sc = new Scanner (System.in);
    static int N=sc.nextInt();
    static long[][] matrix=new long[N][N];

    public static void main(String[] args) {
        getInput();
        while(matrix[0][0]>matrix[0][N-1] || matrix[0][0]>matrix[N-1][0]){
            rotateGrid(matrix);
        }
        for(int r=0; r<N; r++) {
            String out="";
            for(int c=0; c<N; c++){
                out+=matrix[r][c]+" ";
            }
            System.out.println(out);
        }
    }

    static void rotateGrid(long[][] pMatrix){
        for(int r=0; r<N/2; r++){
            for(int c=r; c<N-1-r; c++){
                long temp=matrix[r][c];
                matrix[r][c]=matrix[N-1-c][r];
                matrix[N-1-c][r]=matrix[N-1-r][N-1-c];
                matrix[N-1-r][N-1-c]=matrix[c][N-1-r];
                matrix[c][N-1-r]=temp;
            }
        }
    }

    static void getInput(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                matrix[r][c]=sc.nextInt();
            }
        }
    }
}

