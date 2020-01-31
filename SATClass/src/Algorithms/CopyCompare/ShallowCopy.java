package Algorithms.CopyCompare;

import java.util.*;

public class ShallowCopy {
    public static void main(String[] args) {
        try {
            Student oS1, oS2;
            ArrayList<String> oC = new ArrayList<String>();
            oC.add("Math");
            oC.add("English");
            oC.add("Computer");
            int[] aF = new int[] {11112, 11113};
            oS1 = new Student("James", 11111, oC, aF);

            System.out.println("----- New Variable - B4 -----");
            // assign object to a new variable - not copy
            oS2 = oS1;
            oS1.printStudent();
            oS2.printStudent();

            System.out.println("----- New Variable - After -----");
            oS2.iID = 22222;
            oS2.sName = "~~Eric~~";
            oS2.aFriends[0] = 33333;
            oS2.oCourses.add("~~History~~");
            oS1.printStudent();
            oS2.printStudent();

            System.out.println("----- Shallow Copy - B4 -----");
            // shallow copy
            oS2 = (Student) oS1.clone();
            oS1.printStudent();
            oS2.printStudent();

            System.out.println("----- Shallow Copy - After -----");
            oS2.iID = 55555;
            oS2.oCourses.add("%%Physics%%");
            oS2.sName = "%%Jason%%";
            oS2.aFriends[0] = 66666;
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
            return super.clone();
        }

        public void printStudent() {
            System.out.println("Object: " + this);
            System.out.println("oCourses: " + System.identityHashCode(oCourses));
            System.out.println("aFriends: " + aFriends);
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            System.out.println("Student: " + sName + ", " + iID);
            System.out.println(oCourses);
            System.out.println(Arrays.toString(aFriends));
            System.out.println("");
        }
    }
}
