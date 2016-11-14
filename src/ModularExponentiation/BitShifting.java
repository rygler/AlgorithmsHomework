package ModularExponentiation;

/**
 * Created by Raphael on 11/14/2016.
 */
public class BitShifting {
    public static int modularExponentiation(int base, int exponent, int modulus) {
        if (modulus == 1) {
            return 0;
        }

        int result = 1;
        base = base % modulus;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }

            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }

        return result;
    }
}
