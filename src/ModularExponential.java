/**
 * Created by Raphael on 9/21/2016.
 */
public class ModularExponential {
    public int modExpBruteForce(int base, int exponent, int mod) {
        if (exponent < 0) {
            throw new RuntimeException("number cannot be negative");
        } else if (exponent == 0) {
            return 1 % mod;
        } else {
            int newBase = base;
            for (int i = 1; i < exponent; i++) {
                newBase *= base;
            }
            return newBase % mod;
        }
    }

    public static int modpow(int value , int power, int mod){
        int e = 1;

        for (int i = 0; i < power; i++) {
            e = ((e * value) % mod);

        }

        return e;
    }

    // Look up bitwise operators and check the numbers that get chopped off at the end
//    public static int modexp(int num) {
//
//    }

//    public static int[] getSquares(int num, int mod, int bound) {
//
//        for (int i = 0; i < bound; i++) {
//
//        }
//    }

    /*
    for (i = 0; i < a.length ; i ++) { or while result != 0
        if (num & 1 = 1) {
            answer = answer * a[i] % mod  ;

        }
        num = num >> 1;
    }
     */

    public static int modExp(int base, int power, int mod) {
//        Integer.
        return 0;
    }
}
