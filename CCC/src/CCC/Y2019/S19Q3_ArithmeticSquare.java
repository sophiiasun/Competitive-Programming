package CCC.Y2019;

import java.util.*;

public class S19Q3_ArithmeticSquare {

    static int[][] arr = new int[3][3];
    static int M = Integer.MAX_VALUE;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in;
        count = 0; //number of empty slots
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                in = sc.next();
                if (in.equals("X"))
                    arr[i][j] = M;
                else {
                    arr[i][j] = Integer.parseInt(in);
                    count++;
                }
            }
        }

        while (count < 9) {
            int cur = count;
            fillValue();
            if (cur == count)
                addOne();
        }

        System.out.println(arr[0][0] + " " + arr[0][1] + " " + arr[0][2]);
        System.out.println(arr[1][0] + " " + arr[1][1] + " " + arr[1][2]);
        System.out.println(arr[2][0] + " " + arr[2][1] + " " + arr[2][2]);
    }

    static void addOne() {
        if (arr[1][1] == M) {
            arr[1][1] = 0;
            count ++;
            return;
        }

        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                if (arr[r][c] == M) {
                    // Need to have even difference from opposite #
                    if (r == 0 && arr[2][c] != M) {
                        arr[r][c] = arr[2][c] - 2;
                    } else if (c == 0 && arr[r][2] != M) {
                        arr[r][c] = arr[r][2] - 2;
                    } else if (r == 0 && c == 0 && arr[2][2] != M) {
                        arr[r][c] = arr[2][2] - 2;
                    } else {
                        arr[r][c] = count + 1;
                    }
                    count++;
                    return;
                }
            }
        }

    }

    static void fillValue() {
        for (int i = 0; i < 3; i++) { //check for fillable values col by col
            if (arr[0][i] != M && arr[1][i] == M && arr[2][i] != M ) { // {#, X, #}
                arr[1][i] = (arr[0][i] + arr[2][i]) >> 1; count++;
            } else if (arr[0][i] == M && arr[1][i] != M && arr[2][i] != M) { // {X, #, #}
                arr[0][i] = (arr[1][i] << 1) - arr[2][i]; count++;
            } else if (arr[0][i] != M && arr[1][i] != M && arr[2][i] == M) { // {#, #, X}
                arr[2][i] = (arr[1][i] << 1) - arr[0][i]; count++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] != M && arr[i][1] == M && arr[i][2] != M ) { // {#, X, #}
                arr[i][1] = (arr[i][0] + arr[i][2]) >> 1; count++;
            } else if (arr[i][0] == M && arr[i][1] != M && arr[i][2] != M ) { // {X, #, #}
                arr[i][0] = (arr[i][1] << 1) - arr[i][2]; count++;
            } else if (arr[i][0] != M && arr[i][1] != M && arr[i][2] == M ) { // {#, #, X}
                arr[i][2] = (arr[i][1] << 1) - arr[i][0]; count++;
            }
        }
    }
}
