package DMOPC;

import java.io.*;

public class DMOPC14_NewStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
        int I = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < I; i++)
            sum += Integer.parseInt(br.readLine());

        int S = Integer.parseInt(br.readLine());
        double avg;
        for (int i = 1; i <= S; i++) {
            sum += Integer.parseInt(br.readLine());
            avg = (double)sum / (++I);
            System.out.println(String.format("%.3f%n", avg));
        }
    }
}
