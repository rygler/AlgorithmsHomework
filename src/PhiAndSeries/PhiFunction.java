package PhiAndSeries;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raphael on 9/11/2016.
 */
public class PhiFunction {

    public static Set<Integer> getPhiValues(int number) {
        HashSet<Integer> values = new HashSet<>();

        for (int i = 1; i < number; i++) {
            if (getGCD(number, i) == 1) {
                values.add(i);
            }
        }

        return values;
    }

    private static int getGCD(int number, int i) {
        while (number != i) {
            if (number > i) {
                number = number - i;
            } else {
                i = i - number;
            }
        }

        return number;
    }

    public static long getPhiValuesOfBigInt() {
        BigInteger bigInteger = new BigInteger("24000000000000000000000000");
        long l = 0;

        for (BigInteger bi = bigInteger;
             bi.compareTo(BigInteger.ZERO) > 0;
             bi = bi.subtract(BigInteger.ONE)) {

            if (getGCD(bigInteger, bi).equals(BigInteger.ONE)) {
                l++;
            }
        }
        return l;
    }

    private static BigInteger getGCD(BigInteger bigInteger, BigInteger bi) {
        while (!bigInteger.equals(bi)) {
            if (bigInteger.compareTo(bi) > 0) {
                bigInteger = bigInteger.subtract(bi);
            } else {
                bi = bi.subtract(bigInteger);
            }
        }

        return bigInteger;
    }


}
