package J2019;

import java.util.ArrayList;
import java.util.Scanner;

public class J2019Q2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int L = Integer.parseInt(reader.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            list.add(reader.nextLine());
        }
        for (int j = 0; j < L; j++) {
            String i = list.get(j), output = "";
            int N = Integer.parseInt(i.substring(0, 1));
            char x = i.charAt(2);
            for (int k = 0; k < N; k++) {
                output += x;
            }
            System.out.println(output);
        }
    }
}
