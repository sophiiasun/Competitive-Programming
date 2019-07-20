package J2019;

import java.util.ArrayList;
import java.util.Scanner;

public class J2019Q3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = Integer.parseInt(reader.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(reader.nextLine());
        }
        for (int i = 0; i < N; i++) {
            String obj = list.get(i), output = "";
            while (obj.length() > 0) {
                char x = obj.charAt(0);
                int len = 1, pos = 1;
                while (pos < obj.length() && obj.charAt(pos) == obj.charAt(pos - 1)) {
                    len++;
                    pos++;
                }
                output += len + " " + x + " ";
                obj = obj.substring(len);
            }
            System.out.println(output);
        }
    }
}
