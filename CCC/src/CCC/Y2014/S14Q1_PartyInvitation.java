package CCC.Y2014;

import java.util.*;

public class S14Q1_PartyInvitation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 1; i <= K; i++)
            arr1.add(i);

        int rounds = sc.nextInt();
        for (int i = 0; i < rounds; i++) {
            int r = sc.nextInt();
            for (int j = 1; j <= arr1.size(); j++) {
                if (j % r > 0)
                    arr2.add(arr1.get(j-1));
            }
            arr1.clear();
            arr1.addAll(arr2);
            arr2.clear();
        }
        for (int i = 0; i < arr1.size(); i++)
            System.out.println(arr1.get(i));
    }
}
