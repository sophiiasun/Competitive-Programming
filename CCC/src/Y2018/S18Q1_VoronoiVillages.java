package Y2018;

import java.util.*;

public class S18Q1_VoronoiVillages {
    static int N;
    static double[] in;
    static double min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        init();
        run();
        String out = String.format("%.1f", min);
        System.out.println(out);
    }
    static void run() {
        double tmp;
        for (int i = 1; i < N - 1; i++) {
            tmp = (in[i + 1] - in[i - 1]) / 2;
            if (tmp < min)
                min = tmp;
        }
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        in = new double[N];
        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
        }
        Arrays.sort(in);
    }
}
