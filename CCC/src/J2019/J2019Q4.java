package J2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class J2019Q4 {
    public static void main(String[] args) {
        Random random=new Random();
        Scanner reader = new Scanner(System.in);
        String R = reader.nextLine();
        boolean h=false, v=false;
        for(int i=0; i<1000000; i++){
            if (R.charAt(i)=='H') h = !h;
            else v = !v;
        }
        int[] arr={1,2,3,4};
        int temp=0;
        if(h){
            temp=arr[0]; arr[0]=arr[2]; arr[2]=temp;
            temp=arr[1]; arr[1]=arr[3]; arr[3]=temp;
        } else if(v){
            temp=arr[0]; arr[0]=arr[1]; arr[1]=temp;
            temp=arr[2]; arr[2]=arr[3]; arr[3]=temp;
        }
        System.out.println(arr[0]+" "+arr[1]);
        System.out.println(arr[2]+" "+arr[3]);
    }
}