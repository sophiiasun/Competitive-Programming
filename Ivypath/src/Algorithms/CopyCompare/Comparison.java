package Algorithms.CopyCompare;

import java.util.*;

public class Comparison {
    public static void main(String[] args) {
        ArrayList<String> oC1 = new ArrayList<String>();
        oC1.add("Math");
        oC1.add("English");
        oC1.add("Computer");
        int[] aF1 = new int[] {11112, 11113};
        Student oS1 = new Student("James", 11111, oC1, aF1);

        ArrayList<String> oC2 = new ArrayList<String>();
        oC2.add("Math");
        oC2.add("English");
        oC2.add("Computer");
        int[] aF2 = new int[] {11112, 11113};
        Student oS2 = new Student("James", 11111, oC2, aF2);

        System.out.println("----- Shallow Compare 01");
        System.out.println(oS1 == oS2);

        System.out.println("----- Shallow Compare 02 / Deep Compare");
        System.out.println(oS1.equals(oS2));
    }

    private static class Student implements Cloneable {
        public String sName;
        public int iID;
        public ArrayList<String> oCourses;
        public int[] aFriends;

        public Student(String sN, int iI, ArrayList<String> oC, int[] aF)
        {
            sName = sN;
            iID = iI;
            oCourses = new ArrayList<String>();
            oCourses = (ArrayList<String>) oC.clone();
            aFriends = Arrays.copyOf(aF, aF.length);
        }

        // Shallow Compare
        public boolean equals(Object oOth) {
            if(iID != ((Student) oOth).iID)
                return false;
            if(sName != ((Student) oOth).sName)
                return false;
            if(oCourses != ((Student) oOth).oCourses)
                return false;
            if(aFriends != ((Student) oOth).aFriends)
                return false;

            return true;
        }

        // Deep Compare
        /*
        public boolean equals(Object oOth)
        {
            if(!sName.equals(((Student) oOth).sName))
                return false;
            if(iID != ((Student) oOth).iID)
                return false;
            if(!oCourses.equals(((Student) oOth).oCourses))
                return false;
            if(!Arrays.equals(aFriends, ((Student) oOth).aFriends))
                return false;

            return true;
        }
        */
    }
}
