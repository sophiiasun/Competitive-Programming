package CCC.Y2022;

import java.util.*;
import java.io.*;

public class S1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), ans = 0;
        for (int i = 0; i <= N; i+=5) {
            if ((N-i)%4 == 0) ans++;
        }
        System.out.println(ans);
    }
}
