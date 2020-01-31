package Y2014;

import java.util.*;

public class S14Q2_AssigningPartners {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); sc.nextLine();
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] atmp = {arr1[i], arr2[i]};
            Arrays.sort(atmp);
            String tmp = atmp[0] + atmp[1];
            set.add(tmp);
        }
        System.out.println((set.size() == N>>1) ? "good" : "bad");
    }
}
