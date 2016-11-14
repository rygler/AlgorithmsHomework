import ModularExponentiation.BitShifting;
import ModularExponentiation.Homegrown;

public class Main {

    public static void main(String[] args) {
        System.out.println(Homegrown.modularExponentiation(4, 13, 497));

        System.out.println(BitShifting.modularExponentiation(4, 13, 497));

        System.out.println(UniqueString.isUniqueChars("abcdefgarjiok"));
    }
}
