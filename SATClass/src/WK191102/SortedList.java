package WK191102;

import java.util.*;

public class SortedList { //Complexity O(NlogN)
    private LinkedList<MapElmt> oList = new LinkedList();
    public void put(MapElmt aNew) {
        int iInd = findIndex(aNew.iKey);
        if(iInd < 0)
            oList.get(-1 * (iInd + 1)).iValue = aNew.iValue;
        else
            oList.add(iInd, aNew);
    }
    public MapElmt getLast() {
        return oList.get(oList.size() - 1);
    }
    public void remove(int iKey) {
        int iInd = findIndex(iKey);
        if(iInd < 0)
            oList.remove(-1 * (iInd + 1));
    }
    public int getIndex(int iKey) {
        int iInd = findIndex(iKey);
        if(iInd < 0)
            return -1 * (iInd + 1);
        else
            return -1;
    }
    public int getValue(int iKey) {
        int iInd = findIndex(iKey);
        if(iInd < 0)
            return oList.get(-1 * (iInd + 1)).iValue;
        else
            return -1;
    }
    public int findIndex(int iKey) {
        int iV = iKey;
        if(oList.size() == 0)
            return 0;
        int iMin = 0, iMax = oList.size() - 1, iMid;
        int iVMin = oList.get(iMin).iKey, iVMax = oList.get(iMax).iKey;
        if(iV < iVMin)
            return 0;
        if(iV > iVMax)
            return iMax + 1;
        while(iMin <= iMax) {
            iMid = (iMin + iMax) / 2;
            int iVMid = oList.get(iMid).iKey;
            if(iVMid == iV)
                return -1 * (iMid + 1);
            else {
                if(iVMid < iV)
                    iMin = iMid + 1;
                else
                    iMax = iMid - 1;
            }
        }
        return iMin;
    }
    public String toString(){
        String sRet = "{";
        for(int i = 0; i < oList.size(); i++) {
            if(i < oList.size() - 1)
                sRet += oList.get(i).toString() + ", ";
            else
                sRet += oList.get(i).toString();
        }
        sRet += "}\n";
        return sRet;
    }
}
class MapElmt {
    public int iKey, iValue;
    public MapElmt(int iK, int iV) {
        iKey = iK;
        iValue = iV;
    }
    public String toString() {
        return "(" + iKey + ", " + iValue + ")";
    }
}