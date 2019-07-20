package J2019;

import java.util.ArrayList;
import java.util.Scanner;

public class J2019Q1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            points.add(reader.nextInt());
        }
        int teamA = 3 * points.get(0) + 2 * points.get(1) + points.get(2);
        int teamB = 3 * points.get(3) + 2 * points.get(4) + points.get(5);
        if (teamA > teamB) {
            System.out.println("A");
        } else if (teamB > teamA) {
            System.out.println("B");
        } else {
            System.out.println("T");
        }
    }
}
