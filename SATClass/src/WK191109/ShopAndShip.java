package WK191109;

import java.util.*;

public class ShopAndShip {
    static int N, T, K, D;
    static Point[] trade;
    static int[][] price;
    public static void main(String[] args) {

    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        trade = new Point[T];
        for (int i = 0; i < T; i++)
            trade[i] = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        K = sc.nextInt();
        price = new int[K][2];
        for (int i = 0; i < K; i++) {
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
        }
        D = sc.nextInt();
    }
    static class Point{
        int x;
        int y;
        int c;
        Point(int px, int py, int pc) {
            x = px;
            y = py;
            x = pc;
        }
    }
}
