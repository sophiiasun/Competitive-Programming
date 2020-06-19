package CCC.Y2013;
import java.util.*;

public class J13Q4_TimeOnTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), C = sc.nextInt(), arr[] = new int[C];
        for (int i = 0; i < C; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int time = 0, count = 0;
        for (int i = 0; i < C; i++) {
            time += arr[i];
            if (time > T) break;
            count++;
        }
        System.out.println(count);
    }
}
