package Y2007;

import java.util.*;
import java.io.*;

public class S07Q4_Waterpark2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 2<<20);
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++)
            arr[i] = new ArrayList<>();
        String[] in = br.readLine().split(" ");
        while (!in[0].equals("0")) {
            int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]);
            arr[a].add(b);
            in = br.readLine().split(" ");
        }
        int[] dis = new int[N+1];
        dis[N] = 1;
        for (int i = N-1; i >= 1; i--) {
            for (int j : arr[i]) {
                dis[i] += dis[j];
            }
        }
        System.out.println(dis[1]);
    }
}
