package Algorithms;

import java.util.*;

public class PriorityQueue {
    public static void main(String[] args) {
        usingInteger();
        usingString();
    }
    private static void usingInteger() {
        java.util.PriorityQueue<Integer> oQ = new java.util.PriorityQueue<>();
        oQ.add(10);
        oQ.add(1);
        oQ.add(7);
        oQ.add(2);
        while (!oQ.isEmpty()) {
            System.out.println(oQ.poll());
        }
    }

    private static void usingString() {
        java.util.PriorityQueue<String> oQ = new java.util.PriorityQueue<>();//(new CompDesc());
        oQ.add("hello");
        oQ.add("world");
        oQ.add("bonjour");
        oQ.add("bienvenue");
        while (!oQ.isEmpty()) {
            System.out.println(oQ.poll());
        }
    }

}

class CompDesc implements Comparator<String> {
    public int compare(String s1, String s2) {
        return -1 * s1.compareTo(s2);
    }
}
