package Permutations;

public class PermutationsMatcher {

    public static boolean isPermutation(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        int checker = 0;

        for (int i = 0; i < string1.length(); i++) {
            checker ^= string1.charAt(i) ^ string2.charAt(i);
        }

        return checker == 0;
    }
}
