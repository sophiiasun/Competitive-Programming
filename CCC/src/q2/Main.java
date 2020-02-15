package q2;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] team1 = new int[N + 1];
        int[] team2 = new int[N + 1];
        for (int i = 1; i <= N; i++)
            team1[i] = sc.nextInt() + team1[i-1];
        for (int i = 1; i <= N; i++)
            team2[i] = sc.nextInt() + team2[i-1];

        for (int i = N; i >= 0; i--) {
            if (team1[i] == team2[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
