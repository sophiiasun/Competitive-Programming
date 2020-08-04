package CCC.Y2018;

import java.util.Scanner;

public class J18Q4_Sunflowers { //Same question as S2

    static Scanner sc = new Scanner (System.in);
    static int N=sc.nextInt();
    static long[][] arr =new long[N][N];

    public static void main(String[] args) {
        getInput();
        while(arr[0][0]> arr[0][N-1] || arr[0][0]> arr[N-1][0]){
            rotateGrid();
        }
        for(int r=0; r<N; r++) {
            String out="";
            for(int c=0; c<N; c++){
                out+= arr[r][c]+" ";
            }
            System.out.println(out);
        }
    }

    static void rotateGrid(){
        for(int r=0; r<N/2; r++){
            for(int c=r; c<N-1-r; c++){
                long temp= arr[r][c];
                arr[r][c]= arr[N-1-c][r];
                arr[N-1-c][r]= arr[N-1-r][N-1-c];
                arr[N-1-r][N-1-c]= arr[c][N-1-r];
                arr[c][N-1-r]=temp;
            }
        }
    }

    static void getInput(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c]=sc.nextInt();
            }
        }
    }
}

