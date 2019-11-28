import java.util.Arrays;

import static java.lang.Double.MAX_VALUE;

public class test { //difference array
    public static void main(String[] args) {
        int[] reg = {13, 2, 56, 7, 4, 3, 2, 56, 82, 13, 35, 53};
        int[] dif = new int[12];
        dif[0] = reg[0];
        for (int i = 1; i < 12; i++) {
            dif[i] = reg[i] - reg[i-1];
        }
        System.out.println(Arrays.toString(reg));
        System.out.println(Arrays.toString(dif));
        System.out.println("=============================");
        dif[3] = dif[3] + 3;
        dif[7] = dif[7] - 3;
        for (int i = 1; i < 12; i++)
            reg[i] = reg[i-1] + dif[i];
        System.out.println(Arrays.toString(reg));
    }
}
