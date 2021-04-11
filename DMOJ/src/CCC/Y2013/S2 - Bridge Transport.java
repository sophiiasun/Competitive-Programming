import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(), N = sc.nextInt();
        int[] arr = new int[N + 3];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        int tmp = 0, counter = 0;
        for (int i = 0; i < N; i++) {
            tmp += arr[i];
            if (i>=4) tmp -= arr[i-4];
            if (tmp > W) { System.out.println(counter); return; }
            counter++;
        }
        System.out.println(N);
    }
}