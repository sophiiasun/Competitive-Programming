package Algorithms;

//Determine all possible subset in a given array

public class Subsets {
    public static void main(String[] args){
        char[] aS = {'a', 'b', 'c', 'd', 'e'};
        printAll(aS);
    }
    static void printAll(char[] aS) {
        int N = aS.length;
        int cnt = 0;
        for (int i = 0; i < 1 << N; i++) {
            System.out.print("{");
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0)
                    System.out.print(aS[j] + " ");
            }
            System.out.println("}");
            cnt++;
        }
        System.out.println(cnt);
    }
}
