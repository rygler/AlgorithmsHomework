package Permutations;

/**
 * Created by Raphael on 11/14/2016.
 */
public class PermutationsOfPalindrome {
    public static boolean isPermutationOfPalindrome(String s) {
        int[] counts = getCharacterCounts(s);
        if (checkMaximumOneOddChar(counts)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkMaximumOneOddChar(int[] charCounts) {
        int counter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] % 2 != 0) {
                counter++;
                if (counter > 1) {
                    return false;
                }
            }

        }
        return true;
    }

    private static int[] getCharacterCounts(String s) {
        int[] counts = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : s.toCharArray()) {
            int x = charMap(c);
            if (x != -1) {
                counts[x]++;
            }
        }
        return counts;
    }

    private static int charMap(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
