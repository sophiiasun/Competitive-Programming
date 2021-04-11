package CCC.Y2018;

import java.util.Scanner;

public class J18Q2_OccupyParking {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String in1 = sc.next();
        String in2 = sc.next();
        int counter = 0;
        for (int i = 0; i < N; i++) {
            if (in1.charAt(i) == in2.charAt(i) && in1.charAt(i) == 'C')
                counter++;
        }
        System.out.println(counter);
    }
}
