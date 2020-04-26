package Miscellaneous.USACO;

import java.io.*;

public class USACO20_MadScientist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine(), B = br.readLine();
        int counter = 0;
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = i; j < N; j++) {
                if (A.charAt(j) != B.charAt(j))
                    tmp++;
                else {
                    i = j; break;
                }
            }
            if (tmp > 0) counter++;
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        out.println(counter);
        out.flush();
        out.close();
        System.exit(0);
    }
}
