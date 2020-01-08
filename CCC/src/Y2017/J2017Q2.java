package Y2017;

import java.util.Scanner;
public class J2017Q2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int sum = N;
        for (int i = 1; i <= k; i++) {
            sum += N * Math.pow(10, i);
        }
        System.out.println(sum);
    }
}
