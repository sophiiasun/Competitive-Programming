package J2016;

import java.util.Scanner;

public class J2016Q2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[][] arr=new int[4][4];
        int total=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                arr[i][j]=sc.nextInt();
                total+=arr[i][j];
            }
        }
        if(total/4==arr[0][0]+arr[0][1]+arr[0][2]+arr[0][3]){
            if(total/4==arr[0][0]+arr[1][0]+arr[2][0]+arr[3][0]){
                System.out.println("magic");
            } else {
                System.out.println("not magic");
            }
        } else {
            System.out.println("not magic");
        }
    }
}
