package J2017;

import java.util.Scanner;

public class J2017Q4 {
    static int[] time={1, 2, 0, 0};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int min=sc.nextInt();
        int counter=0;
        for(int i=0; i<min; i++){
            time[3]++;
            if(time[3]>9) nextMinute();
            if(time[2]>5) nextHour();
            if(time[0]==1 && time[1]==2 && time[2]==5 && time[3]==9) nextDay();
            if(time[0]==0) {
                if (time[3] - time[2] == time[2] - time[1]) counter++;
            }else{
                if(time[3]-time[2]==time[2]-time[1] && time[2]-time[1]==time[1]-time[0]) counter++;
            }
        }
        System.out.println(counter);
    }

    static void nextMinute(){
        time[3]=0;
        time[2]++;
    }

    static void nextHour(){
        time[3]=0;
        time[2]=0;
        time[1]++;
    }

    static void nextDay(){
        time[3]=0;
        time[2]=0;
        time[1]=0;
        time[0]=0;
    }

}
