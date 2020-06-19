package CCC.Y2017;

import java.util.Scanner;
public class J17Q1_QuadrantSelection {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt(), y=sc.nextInt();
        if(x>0 && y>0) System.out.println("1");
        else if(x<0 && y>0) System.out.println("2");
        else if(x>0 && y<0) System.out.println("4");
        else System.out.println("3");
    }
}
