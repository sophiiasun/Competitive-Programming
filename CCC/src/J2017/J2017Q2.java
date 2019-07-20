package J2017;

import java.util.Scanner;
public class J2017Q2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String N=sc.nextLine();
        int x=sc.nextInt(), sum=Integer.parseInt(N);
        for(int i=1; i<x+1; i++){
            N+="0";
            sum+=Integer.parseInt(N);
        }
        System.out.println(sum);
    }
}
