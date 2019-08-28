package WK190525;

import java.util.*;

public class test {
    public static int N;
    public static int[][] Cows;

    public static void main(String[] args)
    {
        Scanner oIn = new Scanner(System.in);
        N = oIn.nextInt();
        Cows = new int[N][2];
        for(int i = 0; i < N; i++)
        {
            Cows[i][0] = oIn.nextInt();
            Cows[i][1] = oIn.nextInt();
        }

        int[] XLow, XHigh, YLow, YHigh;
        XLow = new int[4];
        XHigh = new int[4];
        YLow = new int[4];
        YHigh = new int[4];

        Arrays.sort(Cows, Comparator.comparing(a -> a[0]));
        for(int i = 0; i < 4; i++)
        {
            XLow[i] = Cows[i][0];
            XHigh[i] = Cows[N - 1 - i][0];
        }
        Arrays.sort(Cows, Comparator.comparing(a -> a[1]));
        for(int i = 0; i < 4; i++)
        {
            YLow[i] = Cows[i][1];
            YHigh[i] = Cows[N - 1 - i][1];
        }

        int iArea = Integer.MAX_VALUE, iATmp;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                for(int k = 0; k < 4; k++)
                {
                    for(int l = 0; l < 4; l++)
                    {
                        iATmp = calcArea(XLow[i], XHigh[j], YLow[k], YHigh[l]);
                        if(iATmp < iArea)
                            iArea = iATmp;
                    }
                }
            }
        }
        System.out.println(iArea);
    }

    public static int calcArea(int iX1, int iX2, int iY1, int iY2)
    {
        int iRet = Integer.MAX_VALUE;
        if(iX2 <= iX1 || iY2 <= iY1)
            return iRet;

        int iCount = 0;
        for(int i = 0; i < N; i++)
        {
            if(Cows[i][0] < iX1 || Cows[i][0] > iX2 || Cows[i][1] < iY1 || Cows[i][1] > iY2)
                iCount++;
            if(iCount > 3)
                break;
        }
        if(iCount <= 3)
            iRet = (iX2 - iX1) * (iY2 - iY1);
        return iRet;
    }
}
