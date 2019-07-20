package J2019;

import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class J2019Q5 {

    static String[] chg1=new String[2];
    static String[] chg2=new String[2];
    static String[] chg3=new String[2];
    static int N=0;
    static String inp="", out="";

    public static void main(String[] args){
        getInput();
    }

    public static void getInput(){
        Scanner sc=new Scanner(System.in);
        chg1=sc.nextLine().split(" ");
        chg2=sc.nextLine().split(" ");
        chg3=sc.nextLine().split(" ");
        N=sc.nextInt();
        //inp=sc.nextLine().(" ");
        System.out.println(inp);
    }

}
