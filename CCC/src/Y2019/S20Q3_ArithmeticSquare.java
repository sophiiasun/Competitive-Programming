package Y2019;

import java.util.*;

public class S20Q3_ArithmeticSquare {

    static int[][] arr = new int[3][3];
    static int M = Integer.MAX_VALUE;
    static int XC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in;
        XC = 0; //number of empty slots
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                in = sc.next();
                if (in.equals("X")) {
                    arr[i][j] = M;
                    XC++;
                } else arr[i][j] = Integer.parseInt(in);
            }
        }

        while (XC > 0) {
            int cur = XC;
            fillValue();
            if (cur == XC)
                addOne();
        }

        printout();
    }

    static void addOne() {
        if (arr[1][1] == M) {
            arr[1][1] = 0;
            XC--;
            return;
        }

    }

    static void fillValue() {
        for (int i = 0; i < 3; i++) { //check for fillable values col by col
            if (arr[0][i] != M && arr[1][i] == M && arr[2][i] != M ) { // {#, X, #}
                arr[1][i] = (arr[0][i] + arr[2][i]) >> 1; XC--;
            } else if (arr[0][i] == M && arr[1][i] != M && arr[2][i] != M) { // {X, #, #}
                arr[0][i] = (arr[1][i] << 1) - arr[2][i]; XC--;
            } else if (arr[0][i] != M && arr[1][i] != M && arr[2][i] == M) { // {#, #, X}
                arr[2][i] = (arr[1][i] << 1) - arr[0][i]; XC--;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] != M && arr[i][1] == M && arr[i][2] != M ) { // {#, X, #}
                arr[i][1] = (arr[i][0] + arr[i][2]) >> 1; XC--;
            } else if (arr[i][0] == M && arr[i][1] != M && arr[i][2] != M ) { // {X, #, #}
                arr[i][0] = (arr[i][1] << 1) - arr[i][2]; XC--;
            } else if (arr[i][0] != M && arr[i][1] != M && arr[i][2] == M ) { // {#, #, X}
                arr[i][2] = (arr[i][1] << 1) - arr[i][0]; XC--;
            }
        }
    }

    static void printout() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j > 0)
                    sb.append(" ");
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
