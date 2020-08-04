package CCC.Y2012;

import java.util.*;

public class S12Q4_ACoinGame {
    private static Set<CoinState> oVisited = new HashSet<CoinState>();
    private static Queue<CoinState> oQBfs = new LinkedList<CoinState>();
    private static CoinState oEnd = new CoinState();
    private static int n;

    public static void main(String[] args) {
        Scanner oIn = new Scanner(System.in);
        n = oIn.nextInt();

        while(n != 0) {
            oVisited.clear();
            oQBfs.clear();
            oEnd.oState.clear();

            for(int i = 1; i <= n; i++)
                oEnd.oState.add(i);
            oEnd.calcHash();

            CoinState oStart = new CoinState();
            for(int i = 0; i < n; i++)
                oStart.oState.add(oIn.nextInt());
            oStart.calcHash();

            int iStep = doBfs(oStart);
            if(iStep >= 0)
                System.out.println(iStep);
            else
                System.out.println("IMPOSSIBLE");

            n = oIn.nextInt();
        }
    }

    private static int doBfs(CoinState oS) {
        oQBfs.add(oS);

        while (!oQBfs.isEmpty()) {
            CoinState oC = oQBfs.poll();
            if(oC.equals(oEnd))
                return oC.iLevel;
            populateChild(oC);
        }
        return -1;
    }

    private static void populateChild(CoinState oP) {
        CoinState oC;
        int iC1 = retrieveTopCoin(oP.oState.get(0));
        int iC2 = retrieveTopCoin(oP.oState.get(1));
        if(iC1 > 0 && ((iC1 < iC2) || iC2 == 0)) {
            oC = oP.moveCoin(0, 1, iC1);
            add2Queue(oC);
        }

        iC1 = retrieveTopCoin(oP.oState.get(n - 1));
        iC2 = retrieveTopCoin(oP.oState.get(n - 2));
        if(iC1 > 0 && ((iC1 < iC2) || iC2 == 0)) {
            oC = oP.moveCoin(n - 1, n - 2, iC1);
            add2Queue(oC);
        }

        for(int i = 1; i < n - 1; i++) {
            int iCurr = retrieveTopCoin(oP.oState.get(i));
            int iPrev = retrieveTopCoin(oP.oState.get(i - 1));
            int iNext = retrieveTopCoin(oP.oState.get(i + 1));

            if(iCurr > 0) {
                if (iCurr < iPrev || iPrev == 0) {
                    oC = oP.moveCoin(i, i - 1, iCurr);
                    add2Queue(oC);
                }
                if (iCurr < iNext || iNext == 0) {
                    oC = oP.moveCoin(i, i + 1, iCurr);
                    add2Queue(oC);
                }
            }
            if (iNext == 0)
                i++;
        }
    }

    private static int retrieveTopCoin(int iV) {
        return iV & 15;
    }

    private static void add2Queue(CoinState oS) {
        if(!oVisited.contains(oS)) {
            oVisited.add(oS);
            oQBfs.add(oS);
        }
    }

    private static class CoinState {
        public ArrayList<Integer> oState;
        public int iHash;
        public int iLevel;
        public CoinState() { oState = new ArrayList<Integer>(); iLevel = 0; iHash = 0; }
        public CoinState(CoinState oC, int iL) {
            iHash = oC.iHash;
            iLevel = iL;
            oState = new ArrayList<>();
            for(int i = 0; i < oC.oState.size(); i++)
                this.oState.add(oC.oState.get(i));
        }

        public void calcHash() {
            this.iHash = 0;
            for(int i = 0; i < n; i++) {
                int iLoc = i;
                int iT = this.oState.get(i);
                while(iT != 0) {
                    int iS = iT & 15;
                    iLoc = iLoc << (4 * (iT - 1));
                    this.iHash = this.iHash ^ iLoc;
                    iT = iT >> 4;
                }
            }
        }

        @Override
        public int hashCode() {
            return iHash;
        }
        @Override
        public boolean equals(Object oOther) {
            return iHash == ((CoinState) oOther).iHash;
        }

        public CoinState moveCoin(int iS, int iD, int iV) {
            CoinState oC = new CoinState(this, this.iLevel + 1);
            oC.oState.set(iS, oC.oState.get(iS) >> 4);
            oC.oState.set(iD, oC.oState.get(iD) << 4);
            oC.oState.set(iD, oC.oState.get(iD) + iV);

            int iX = iS ^ iD;
            iX = iX << (4 * (iV - 1));
            oC.iHash = oC.iHash ^ iX;

            return oC;
        }
    }
}
