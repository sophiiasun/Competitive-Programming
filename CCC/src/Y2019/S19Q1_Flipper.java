package Y2019;

import java.util.Scanner;

public class S19Q1_Flipper {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String R = reader.nextLine();
        boolean h=false, v=false;
        for(int i=0; i<R.length(); i++){
            if (R.charAt(i)=='H') h = !h;
            else v = !v;
        }
        int[] arr={1,2,3,4};
        int temp=0;
        if(h){
            temp=arr[0]; arr[0]=arr[2]; arr[2]=temp;
            temp=arr[1]; arr[1]=arr[3]; arr[3]=temp;
        }
        if(v){
            temp=arr[0]; arr[0]=arr[1]; arr[1]=temp;
            temp=arr[2]; arr[2]=arr[3]; arr[3]=temp;
        }
        System.out.println(arr[0]+" "+arr[1]);
        System.out.println(arr[2]+" "+arr[3]);
    }
}