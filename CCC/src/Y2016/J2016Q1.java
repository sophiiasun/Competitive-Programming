package Y2016;

import java.util.Scanner;

public class J2016Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = 0;
        for (int i=0; i<6; i++){
            if(sc.nextLine().equals("W")) {
                W++;
            }
        }
        if(W==5 || W==6){
            System.out.println("1");
        } else if (W==3 || W==4){
            System.out.println("2");
        } else if (W==1 || W==2){
            System.out.println("3");
        } else {
            System.out.println("-1");
        }
    }
}
