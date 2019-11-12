import static java.lang.Double.MAX_VALUE;

public class test {
    public static void main(String[] args) {
        double dT1 = 2;
        double dT2 = Math.sqrt(dT1);
        dT2 = dT2 * dT2;
        System.out.println(dT1);
        System.out.println(String.format("%.30f", dT2));
        double dTH = 0.000000001;
        System.out.println(Math.abs(dT1 - dT2) < dTH);
        double dT3 = MAX_VALUE;
        double dT4 = dT3++;
        System.out.println(dT3);
        System.out.println(dT4);
        System.out.println(dT3 == dT4);
    }
}
