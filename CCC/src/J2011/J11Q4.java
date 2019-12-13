package J2011;

import java.util.*;

public class J11Q4 {
    static boolean[][] arr = new boolean[200][400];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean danger = false;
        char next;
        int step;
        int r = 4, c = 99;
        do {
            next = sc.next().charAt(0);
            step = sc.nextInt();
            if (next == 'u') { //up
                for (int i = 0; i < step; i++) {
                    if (arr[r-1][c]){
                        System.out.println("DANGER");
                        danger = true;
                    } else {
                        arr[--r][c] = true;
                        System.out.println((-r-1) +" " + (c-100) + " safe");
                    }
                }
            } else if (next == 'd') {
                for (int i = 0; i < step; i++) {
                    if (arr[r+1][c]){
                        System.out.println("DANGER");
                        danger = true;
                    } else {
                        arr[++r][c] = true;
                        System.out.println(r-100 +" " + (-c - 1) + " safe");
                    }
                }
            } else if (next == 'r') {
                for (int i = 0; i < step; i++) {
                    if (arr[c-1][c]){
                        System.out.println("DANGER");
                        danger = true;
                    } else {
                        arr[r][--c] = true;
                        System.out.println(r-100 +" " + (-c - 1) + " safe");
                    }
                }
            } else if (next == 'l') {
                for (int i = 0; i < step; i++) {
                    if (arr[c+1][c]){
                        System.out.println("DANGER");
                        danger = true;
                    } else {
                        arr[r][++c] = true;
                        System.out.println(r-100 +" " + (-c - 1) + " safe");
                    }
                }
            }
        }while(!danger && next != 'q');
    }

    static void init(){
        arr[0][100] = true;
        arr[1][100] = true;
        arr[2][100] = true;
        arr[2][101] = true;
        arr[2][102] = true;
        arr[2][103] = true;
        arr[3][103] = true;
        arr[4][103] = true;
        arr[4][104] = true;
        arr[4][105] = true;
        arr[3][105] = true;
        arr[2][105] = true;
        arr[2][106] = true;
        arr[2][107] = true;
        arr[3][107] = true;
        arr[4][107] = true;
        arr[5][107] = true;
        arr[6][107] = true;
        arr[6][106] = true;
        arr[6][105] = true;
        arr[6][104] = true;
        arr[6][103] = true;
        arr[6][102] = true;
        arr[6][101] = true;
        arr[6][100] = true;
        arr[6][99] = true;
        arr[5][99] = true;
        arr[4][99] = true;
    }
}
