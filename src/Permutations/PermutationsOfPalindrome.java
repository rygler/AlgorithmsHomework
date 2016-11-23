package Permutations;

import java.util.Arrays;

public class PermutationsOfPalindrome {

    private static boolean isPalindromePermutation(String string) {

        string = string.replaceAll("\\s+", "");

        boolean[] indexArray = new boolean[256];
        Arrays.fill(indexArray, true);

        int oddCount = 0;

        for (int i = 0; i < string.length(); i++) {
            int idx = (int) string.charAt(i);
            indexArray[idx] = !indexArray[idx];

            if (indexArray[idx]) {
                oddCount--;
            } else {
                oddCount++;
            }
        }

        return (string.length() % 2 == 0) ? oddCount == 0 : oddCount == 1;
    }
}
