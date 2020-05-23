package CCC.Y2012;

import java.util.*;

public class S12Q4_ACoinGame {
    // BFS visited or not set
    // because we don't know how many nodes there are, we cannot use an array
    private static Set<CoinState> oVisited = new HashSet<CoinState>();
    // BFS level queue
    private static Queue<CoinState> oQBfs = new LinkedList<CoinState>();
    // End State
    private static CoinState oEnd = new CoinState();
    // input - # of coins
    private static int n;

    public static void main(String[] args) {
        Scanner oIn = new Scanner(System.in);
        n = oIn.nextInt();

        // continue until n == 0
        while(n != 0) {
            // clear set, queue & end state for each different test
            oVisited.clear();
            oQBfs.clear();
            oEnd.oState.clear();

            // populate end state
            // the end state is {1, 2, 3} for the sample
            for(int i = 1; i <= n; i++)
                oEnd.oState.add(i);
            // calculate hash for the end state
            oEnd.calcHash();

            // populate start state from input
            // the start state is {3, 2, 1}
            CoinState oStart = new CoinState();
            for(int i = 0; i < n; i++)
                oStart.oState.add(oIn.nextInt());
            // calculate hash for the end state
            oStart.calcHash();

            // do BFS
            int iStep = doBfs(oStart);
            if(iStep >= 0)
                System.out.println(iStep);
            else
                System.out.println("IMPOSSIBLE");

            n = oIn.nextInt();
        }
    }

    private static int doBfs(CoinState oS) {
        // add start to queue
        oQBfs.add(oS);

        while (!oQBfs.isEmpty()) {
            CoinState oC = oQBfs.poll();
            // check whether we reach the end
            if(oC.equals(oEnd))
                return oC.iLevel;
            // populate all children for this state if they are not visited yet
            populateChild(oC);
        }
        return -1;
    }

    // populate all children of this state
    private static void populateChild(CoinState oP) {
        CoinState oC;
        // get position 0's top coin
        int iC1 = retrieveTopCoin(oP.oState.get(0));
        // get position 1's top coin
        int iC2 = retrieveTopCoin(oP.oState.get(1));
        // check whether we can move iC1 to iC2
        // only if iC1 > 0, not blank
        // iC1 < iC2 || iC2 == 0 is blank
        if(iC1 > 0 && ((iC1 < iC2) || iC2 == 0)) {
            // move iC1 from 0 to 1
            oC = oP.moveCoin(0, 1, iC1);
            // check whether we can add oC to queue
            add2Queue(oC);
        }

        // check move from n - 1 to n - 2
        iC1 = retrieveTopCoin(oP.oState.get(n - 1));
        iC2 = retrieveTopCoin(oP.oState.get(n - 2));
        if(iC1 > 0 && ((iC1 < iC2) || iC2 == 0)) {
            oC = oP.moveCoin(n - 1, n - 2, iC1);
            add2Queue(oC);
        }

        // all other moves can be 2 directions & all handled below
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

    // iV is all coins in the same position
    // top is at the last 4 bit
    // next one is 5th to 8th from the back
    // so on so forth
    private static int retrieveTopCoin(int iV) {
        // get last coin by using AND with 0000 0000 1111
        return iV & 15;
    }

    // try to add oS to queue
    private static void add2Queue(CoinState oS) {
        // add to queue if it's not visited
        if(!oVisited.contains(oS)) {
            oVisited.add(oS);
            oQBfs.add(oS);
        }
    }

    // majority of the logic is in CoinState
    private static class CoinState {
        // oState is an ArrayList of each position
        // if there are 3 coins, 3 integers in the ArrayList
        // each position can have 0 to n coins
        // if 0 coin, the position = 0
        // if 1 coin, like 3, the postion is 0000 0011, the last 4 digits is the top one
        // if 2 coins, like 4, 1, the position is 0100 0001, the last 4 is the top one & from 5th to 8th from behind is the 2nd one
        public ArrayList<Integer> oState;
        // we use an integer as hash value, so the comparison will be very fast
        // THIS IS THE MOST IMPORTANT PART FOR THE TIME EFFICIENCE
        // this determins whether you can pass test cases 3, 4 or 5
        public int iHash;
        // each state has a level, child level = parent level + 1
        public int iLevel;

        // constructor
        public CoinState() {
            oState = new ArrayList<Integer>();
            iLevel = 0;
            iHash = 0;
        }

        // constructor from parent
        public CoinState(CoinState oC, int iL) {
            iHash = oC.iHash;
            iLevel = iL;
            oState = new ArrayList<Integer>();
            // do deep copy of parent
            for(int i = 0; i < oC.oState.size(); i++)
                this.oState.add(oC.oState.get(i));
        }

        // calculate hash based on oState
        public void calcHash() {
            // diff way to store the state
            // iHash shows each coin's location
            // 13/2/5/4/0
            // 0010    0011    0000    0001    0000
            // 5 @ 2   4 @ 3   3 @ 0   2 @ 1   1 @ 0
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

        // use iHash as hashcode
        @Override
        public int hashCode() {
            return iHash;
        }

        // use iHash to do equal
        @Override
        public boolean equals(Object oOther) {
            return iHash == ((CoinState) oOther).iHash;
        }

        // move iV from iS position to iD position
        // this is only for parent
        public CoinState moveCoin(int iS, int iD, int iV) {
            // deep copy parent & level + 1
            CoinState oC = new CoinState(this, this.iLevel + 1);
            // update oState
            oC.oState.set(iS, oC.oState.get(iS) >> 4);
            oC.oState.set(iD, oC.oState.get(iD) << 4);
            oC.oState.set(iD, oC.oState.get(iD) + iV);

            // update iHsah
            int iX = iS ^ iD;
            iX = iX << (4 * (iV - 1));
            oC.iHash = oC.iHash ^ iX;

            return oC;
        }
    }
}
