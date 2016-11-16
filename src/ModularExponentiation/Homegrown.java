package ModularExponentiation;

public class Homegrown {

    public static int modularExponentiation(int base, int exponent, int modulus) {
        if (modulus == 1) {
            return 0;
        }

        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result = (result * base) % modulus;
        }

        return result;
    }
}
