package WK191102;

import java.util.*;

public class SortedList {
    public static void main(String[] args) {

    }
    static class sortedList {
        static LinkedList<Map<Integer, Integer>> list = new LinkedList<>();
        sortedList(int findIndex, int getIndex, int[] BinarySearch) {

        }
//      ================================================================================================================
//        static int findIndex(int iK) {
//            if (list.size() == 0) {}
//            else if (iK < list.get(0).get(0))
//                return 0;
//            else if (iK > list.get(list.size()).get(0))
//                return list.size() + 1;
//            else {
//
//            }
//        }
        static void put(Map<Integer, Integer> map) { //=================================================================
            //if found, update iV value
            //if not, add element
        }
        static void remove(int iK) { //=================================================================================
            int[] iR = BinarySearch(0, list.size(), iK);
            if (iR[0] == -1)
                return;
            else {
                //remove element
            }
        }
        static int getValue(int iK) { //================================================================================
            int[] iR = BinarySearch(0, list.size(), iK);
            return iR[1];
        }
        static int getIndex(int iK) { //returns value of index iK ======================================================
            int[] iR = BinarySearch(0, list.size(), iK);
            return iR[0];
        }
        static int[] BinarySearch(int s, int e, int iK) { //return index of iK and value of iV =========================
            if (e >= 1) {
                int mid = (s+e)/2;
                if (list.get(mid).get(0) == iK)
                    return new int[]{mid, list.get(mid).get(1)};
                if (list.get(mid).get(0) > iK)
                    return BinarySearch(s, mid - 1, iK);
                if (list.get(mid).get(0) < iK)
                    return BinarySearch(mid + 1, e, iK);
            }
            return new int[]{-1, -1};
        }
        static StringBuilder toString(int iK) { //======================================================================
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append("(" + list.get(i).get(0) + ", " + list.get(i).get(1) + ")");
                if (i != 0)
                    sb.append(", ");
            }
            return sb;
        }
    }
}
