package J2016;

import java.util.Scanner;

public class J2016Q3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int max=0;
        String input=sc.nextLine(), sub1="", sub2="";
        for(int i=0; i<input.length(); i++){
            sub1=input.substring(i, input.indexOf(input.charAt(i)));
            sub2=input.substring(input.indexOf(input.charAt(i))+1);
            System.out.println(sub1);
            System.out.println(sub2);
            if(chkPal(input)){
                if(sub1.length()>max) max=sub1.length();
            }
        }
        System.out.println(max);
    }

    static boolean chkPal(String input){
        boolean pal=true;
        for(int i=0; i<input.length()/2; i++){
             if(input.indexOf(i)!=input.indexOf(input.length()-1-i)){
                 pal=false;
             }
        }
        return pal;
    }

}
