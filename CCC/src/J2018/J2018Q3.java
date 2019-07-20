package J2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J2018Q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        ArrayList<Integer> cities=new ArrayList<>();
        cities.add(0);
        int x=0, y=0;
        String output="0 ";
        for(int i=0; i<4; i++){
            y=Integer.parseInt(input[i])+x;
            cities.add(y);
            output+=y+" ";
            x=y;
        }
        System.out.println(output);
        output="";
        for(int i=1; i<5; i++){
            for(int j=0; j<5; j++){
                y=Math.abs(cities.get(i)-cities.get(j));
                output+=y+" ";
            }
            System.out.println(output);
            output="";
        }
    }
}
