package J2018;

import java.util.ArrayList;
import java.util.Scanner;

public class J2018Q1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        boolean x=true;
        ArrayList<String> list=new ArrayList<>();
        for(int i=0; i<4; i++){
            list.add(sc.nextLine());
        }
        System.out.println(list);
        String dig="89";
        if(dig.contains(list.get(0)) && dig.contains(list.get(3)) && list.get(1) == list.get(2)){
            x=false;
        }
        if(x){
            System.out.println("answer");
        }else{
            System.out.println("decline");
        }
    }
}
