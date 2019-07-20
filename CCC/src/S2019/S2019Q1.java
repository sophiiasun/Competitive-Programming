package S2019;

import java.util.Arrays;
import java.util.Scanner;

public class S2019Q1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int[][] arr={{1,2},{3,4}};
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='H'){
                int[] temp=arr[0];
                arr[0]=arr[1];
                arr[1]=temp;
            } else {
                int[] temp={arr[0][0], arr[1][0]};
                arr[0][0]=arr[0][1];
                arr[1][0]=arr[1][1];
                arr[0][1]=temp[0];
                arr[1][1]=temp[1];
            }
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
    }
}
