package S2019;

import java.util.Arrays;
import java.util.Scanner;

public class S2019Q3 {
        static int[][] arr = new int[3][3];
        static int M = Integer.MAX_VALUE;
        static int cnt = 0;
    public static void main(String[] args) {
        init();
        run();
        print();
    }

    static void run() {
        while (cnt < 9) {
            System.out.println("run");
            int curCnt = cnt;
            for (int r = 0; r < 3; r++) { // check each row for any fillable values
                if (arr[r][0] == M && arr[r][1] != M && arr[r][2] != M) {
                    arr[r][0] = (arr[r][1] << 1) - arr[r][2];
                    cnt++;
                } else if (arr[r][0] != M && arr[r][1] == M && arr[r][2] != M) {
                    arr[r][1] = (arr[r][0] + arr[r][2]) >> 1;
                    cnt++;
                } else if (arr[r][0] != M && arr[r][1] != M && arr[r][2] == M) {
                    arr[r][2] = (arr[r][1] << 1) - arr[r][0];
                    cnt++;
                }
            }
            for (int c = 0; c < 3; c++) {
                if (arr[0][c] == M && arr[1][c] != M && arr[2][c] != M) {
                    arr[0][c] = (arr[1][c] << 1) - arr[2][c];
                    cnt++;
                } else if (arr[0][c] != M && arr[1][c] == M && arr[2][c] != M) {
                    arr[1][c] = (arr[0][c] + arr[2][c]) >> 1;
                    cnt++;
                } else if (arr[0][c] != M && arr[1][c] != M && arr[2][c] == M) {
                    arr[2][c] = (arr[1][c] << 1) - arr[0][c];
                    cnt++;
                }
            }
            if (curCnt == cnt) {
                addOne();
            }
        }
    }

    static void addOne() {
        if (arr[1][1] == M) {
            arr[1][1] = 0;
            cnt++;
            return;
        }
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if (arr[r][c] == M) {
                    if (r == 0 && arr[2][c] != M) {
                        arr[r][c] = arr[2][c] + 2;
                    } else if (c == 0 && arr[r][2] != M) {
                        arr[r][c] = arr[r][2] + 2;
                    } else {
                        arr[r][c] = 0;
                    }
                    cnt++;
                    return;
                }
            }
        }
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                String s = sc.next();
                if (s.charAt(0) == 'X')
                    arr[i][j] = M;
                else {
                    arr[i][j] = Integer.parseInt(s);
                    cnt++;
                }
            }
        }
    }

    static void print() {
        for(int i = 0; i < 3; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
        }
    }

}
