package Y2011;

import java.util.*;

public class S11Q2_MultipleChoice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] stu = new char[N];
        char[] ans = new char[N];
        for (int i = 0; i < N; i++)
            stu[i] = sc.next().charAt(0);
        for (int i = 0; i < N; i++)
            ans[i] = sc.next().charAt(0);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (stu[i] == ans[i])
                cnt++;
        }
        System.out.println(cnt);
    }
}
