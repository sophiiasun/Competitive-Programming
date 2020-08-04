package CCC.Y2011;

import java.util.*;

public class S11Q4_BloodDistribution {
    static int[][] range = new int[8][]; //patient to blood
    static int[] patients = new int[8];
    static int[] blood = new int[8];
    static int counter = 0;

    public static void main(String[] args) {
        init();
        run();
        for (int i = 0; i < 8; i++)
            counter -= patients[i];
        System.out.println(counter);
    }
    static void run(){
        getBlood(0);
        getBlood(1);
        getBlood(2);
        getBlood(4);
        getBlood(6);
        getBlood(3);
        getBlood(5);
        getBlood(7);
    }
    static void getBlood(int index){ //index represents blood type
        for (int i : range[index]) {
            int min = Math.min(patients[index], blood[i]);
            patients[index] -= min;
            blood[i] -= min;
        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++)
            blood[i] = sc.nextInt();
        for (int i = 0; i < 8; i++) {
            patients[i] = sc.nextInt();
            counter += patients[i];
        }
        range[0] = new int[]{0};
        range[1] = new int[]{1, 0};
        range[2] = new int[]{2, 0};
        range[3] = new int[]{3, 2, 1, 0};
        range[4] = new int[]{4, 0};
        range[5] = new int[]{5, 4, 1, 0};
        range[6] = new int[]{6, 2, 4, 0};
        range[7] = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }
}
