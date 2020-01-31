package Algorithms.CopyCompare;

import java.util.*;

public class DeepCopy {
    public static void main(String[] args) {
        try {
            Student oS1, oS2;
            ArrayList<String> oC = new ArrayList<String>();
            oC.add("Math");
            oC.add("English");
            oC.add("Computer");
            int[] aF = new int[] {11112, 11113};
            oS1 = new Student("James", 11111, oC, aF);

            System.out.println("----- Deep Copy - B4 -----");
            // deep copy
            oS2 = (Student) oS1.clone();
            oS1.printStudent();
            oS2.printStudent();

            System.out.println("----- Deep Copy - After -----");
            oS2.iID = 55555;
            oS2.oCourses.add("%%Physics%%");
            oS2.sName = "%%Jason%%";
            oS2.aFriends[0] = 33333;
            oS1.printStudent();
            oS2.printStudent();

        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static class Student implements Cloneable {
        public String sName;
        public int iID;
        public ArrayList<String> oCourses;
        public int[] aFriends;

        public Student(String sN, int iI, ArrayList<String> oC, int[] aF) {
            sName = sN;
            iID = iI;
            oCourses = new ArrayList<String>();
            oCourses = (ArrayList<String>) oC.clone();
            aFriends = Arrays.copyOf(aF, aF.length);
        }

        public Object clone()throws CloneNotSupportedException{
            Student oNew = (Student) super.clone();
            oNew.oCourses = (ArrayList<String>) oCourses.clone();
            oNew.aFriends = Arrays.copyOf(aFriends, aFriends.length);
            return oNew;
        }

        public void printStudent() {
            System.out.println("Object: " + this);
            System.out.println("oCourses: " + System.identityHashCode(oCourses));
            System.out.println("aFriends: " + aFriends);
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            System.out.println("Student: " + sName + ", " + iID );
            System.out.println(oCourses);
            System.out.println(Arrays.toString(aFriends));
            System.out.println("");
        }
    }
}
