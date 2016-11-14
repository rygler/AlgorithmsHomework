package Permutations;

import java.util.Arrays;

/**
 * Created by Raphael on 11/14/2016.
 */
public class PermutationsOfPalindrome {
    private static boolean isPalindromePermutation(String str) {
        str = str.replaceAll("\\s+","");

        boolean[] indexArray = new boolean[256];
        Arrays.fill(indexArray, true);

        int oddCount = 0;

        for (int i = 0; i < str.length(); i++) {
            int idx = (int) str.charAt(i);
            indexArray[idx] = !indexArray[idx];

            if (indexArray[idx])
                oddCount--;
            else
                oddCount++;
        }

        return (str.length() % 2 == 0) ? oddCount == 0 : oddCount == 1;
    }
}
