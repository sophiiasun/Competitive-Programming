package Y2019;

import java.io.*;
import java.util.*;

public class S19Q3_ArithmeticSquareDadVersion {
    static int[][] arr = new int[3][3];
    static int M = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) {
        init();
        run();
        print();
    }

    static void init() {
        Scanner scanner = new Scanner(System.in);
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                // Scanner will scan next token which id delimited by space chars
                String s = scanner.next();
                if (s.charAt(0) == 'X') {
                    arr[r][c] = M;
                } else {
                    arr[r][c] = Integer.parseInt(s);
                    count ++;
                }
            }
        }
    }

    /*
     * When there are less than 4 #s: If no 2 #s in a row or column, need to add a random #. The added # should have
     *     even difference to any existing number in the opposite position of grid. Or else will get decimal difference.
     *     So the corner 4 #s will all be even or all be odd.
     * When there are 4 #s: if in L shape, add any # to center, can resolve to question. If not in L shape, it is always resolvable
     * When there are more than 4 #s: always resolvable
     *
     * Resolving: scan row by row, then column by column, when there are two #s, calculate the missing one.
     */
    static void run() {
        while (count < 9) {
            int curCount = count;

            // scan row by row
            for (int r=0; r<3; r++) {
                if (arr[r][0] == M && arr[r][1] != M && arr[r][2] != M) {
                    arr[r][0] = (arr[r][1] << 1) - arr[r][2];
                    count ++;
                } else if (arr[r][0] != M && arr[r][1] == M && arr[r][2] != M) {
                    arr[r][1] = (arr[r][0] + arr[r][2]) >> 1;
                    count ++;
                } else if (arr[r][0] != M && arr[r][1] != M && arr[r][2] == M) {
                    arr[r][2] = (arr[r][1] << 1) - arr[r][0];
                    count ++;
                }
            }

            // scan column by column
            for (int c=0; c<3; c++) {
                if (arr[0][c] == M && arr[1][c] != M && arr[2][c] != M) {
                    arr[0][c] = (arr[1][c] << 1) - arr[2][c];
                    count ++;
                } else if (arr[0][c] != M && arr[1][c] == M && arr[2][c] != M) {
                    arr[1][c] = (arr[0][c] + arr[2][c]) >> 1;
                    count ++;
                } if (arr[0][c] != M && arr[1][c] != M && arr[2][c] == M) {
                    arr[2][c] = (arr[1][c] << 1) - arr[0][c];
                    count ++;
                }
            }

            // cannot find anymore, add a number
            if (curCount == count)
                addOne();
        }
    }

    // There must have one empty from (0,0), (0,1), (0,2), (1,0), (1,1). If all these 5 have values, there's no need to addone
    static void addOne() {
        // First check if center is empty
        if (arr[1][1] == M) {
            arr[1][1] = count + 1;
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

    static void print() {
        for (int r=0; r<3; r++) {
            System.out.printf("%d %d %d\n", arr[r][0], arr[r][1], arr[r][2]);
        }
    }
}