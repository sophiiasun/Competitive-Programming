package CCC.Y2011;

import java.util.*;

public class S11Q1_EnglishOrFrench {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int tc = 0, sc = 0;
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            while (str.equals(""))
                str = scanner.nextLine();
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == 't' || str.charAt(j) == 'T')
                    tc++;
                else if (str.charAt(j) == 's' || str.charAt(j) == 'S')
                    sc++;
            }
        }
        if (tc > sc)
            System.out.println("English");
        else
            System.out.println("French");
    }
}
