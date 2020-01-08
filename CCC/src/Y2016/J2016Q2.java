package Y2016;

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
        boolean bln = true;
        for (int i = 0; i < 4; i++) {
            int tmp = 0;
            for (int j = 0; j < 4; j++) {
                tmp += arr[i][j];
            }
            if (tmp != total/4)
                bln = false;
        }
        if(bln) System.out.println("magic");
        else System.out.println("not magic");
    }
}
