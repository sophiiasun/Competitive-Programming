import java.util.*;

public class test { //difference array
    public static void main(String[] args) {
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        set1.add(3);
        set1.add(6);
        set1.add(39);
        set1.add(38);
        set1.add(2);
        set1.add(1);
        set1.add(7);
        set1.add(4);
        set2 = (ArrayList<Integer>)set1.clone();

        for (int i : set2)
            System.out.println(i);
    }
}
