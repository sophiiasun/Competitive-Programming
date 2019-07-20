package S2019;

import java.util.Scanner;

public class S2019Q2 {

    static Scanner sc=new Scanner(System.in);
    static int T=sc.nextInt();
    static int[] arr = new int[T];

    public static void main(String[] args){
        for (int i = 0; i < T; i++)  {
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<T; i++){
            for(int j=arr[i]-1; j>=2; j--){
                if(checkPrime(j)) {
                    int jUp=0;
                    int dif=arr[i]-j;
                    jUp=arr[i]+dif;
                    if(checkPrime(jUp)){
                        String out=j+" "+jUp;
                        System.out.println(out);
                        break;
                    }
                }
            }
        }

    }

    static boolean checkPrime(int N){
        boolean prime=true;
        for(int i=2; i<=Math.sqrt(N); i++){
            if(N%i==0){
                prime=false;
            }
        }
        return prime;
    }

}
