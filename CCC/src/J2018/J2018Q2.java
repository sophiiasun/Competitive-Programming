package J2018;

import java.util.Scanner;

public class J2018Q2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine()), counter=0;
        String X=sc.nextLine();
        String Y=sc.nextLine();
        for(int i=0; i<N; i++){
            if(X.charAt(i)==Y.charAt(i)) counter++;
        }
        System.out.println(counter);
    }
}
