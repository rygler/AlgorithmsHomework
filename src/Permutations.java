import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Raphael on 10/30/2016.
 */
public class Permutations {

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int checker = 0;

        for (int i = 0; i < s1.length(); i++) {
            checker ^= s1.charAt(i) ^ s2.charAt(i);
        }

        return checker == 0;
    }

    public static boolean isPermutationOfPalindrome(String string) {
        boolean[] indexArray = new boolean[256];
        Arrays.fill(indexArray, true);

        int oddCount = 0;

        for (int i = 0; i < string.length(); i++) {
            int idx = (int) string.charAt(i);
            indexArray[idx] = !indexArray[idx];

            if (indexArray[idx])
                oddCount--;
            else
                oddCount++;
        }

        return (string.length() % 2 == 0) ? oddCount == 0 : oddCount == 1;
    }

}
