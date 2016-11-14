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

}
