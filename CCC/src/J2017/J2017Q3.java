package J2017;

import java.util.Scanner;

public class J2017Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] ab = {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
        String[] arr2 = sc.nextLine().split(" ");
        int[] cd = {Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1])};
        int moves = Math.abs(ab[0] - cd[0]) + Math.abs(ab[1] - cd[1]);
        int gas = sc.nextInt();
        if (moves > gas) {
            System.out.println("N");
        } else if (moves == gas) {
            System.out.println("Y");
        } else {
            if ((gas-moves)%2 == 0) {
                System.out.println("Y");
            }else{
                System.out.println("N");
            }
        }
    }
}
