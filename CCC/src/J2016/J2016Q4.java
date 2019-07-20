package J2016;

import java.util.Arrays;
import java.util.Scanner;

public class J2016Q4 {

    static int[] time=new int[3];

    public static void main(String[] args){                //7-10. 15-19
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        time[0]=java.lang.Character.getNumericValue(input.charAt(0));
        time[1]=java.lang.Character.getNumericValue(input.charAt(1));
        time[2]=java.lang.Character.getNumericValue(input.charAt(3));
        for(int i=0; i<8; i++){
            if(time[0]==0) if(time[1]==7 || time[1]==8 || time[1]==9) time[2]+=2;
            if(time[0]==1) if(time[1]==0 || time[1]==5 || time[1]==6 || time[1]==7 || time[1]==8 || time[1]==9) time[2]+=2;
            checkTime();
            time[2]+=2;
            checkTime();
        }
        System.out.println(time[0]+""+time[1]+":"+time[2]+"0");
    }

    static void checkTime(){
        if(time[2]==6) nextHour();
        if(time[1]==2 && time[0]==1) next12Hour();
        if(time[1]==4 && time[0]==2) nextDay();
    }

    static void nextHour(){
        time[2]=0;
        time[1]++;
    }

    static void nextDay() {
        time[2]=0;
        time[1]=0;
        time[0]=0;
    }

    static void next12Hour(){
        time[1]++;
        time[0]++;
    }

}
