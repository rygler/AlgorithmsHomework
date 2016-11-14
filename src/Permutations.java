import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Raphael on 10/30/2016.
 */
public class Permutations {
    public static boolean isStringsPermutationsOfEachOther(String a, String b) {
        int lengthOfA = a.length();
        int lengthOfB = b.length();
        Set stringA = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            stringA.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            if (!stringA.contains(b.charAt(i))) {
                return false;
            }
        }
        LinkedList<Integer>[] arrayOfLinkedLists = new LinkedList[10];
        return lengthOfA == lengthOfB;
    }

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

//    public static boolean isPermutation(String s1, String s2) {
//        if (s1.length() != s2.length()) return false;
//        int checker = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            checker ^= s1.charAt(i) ^ s2.charAt(i);
//        }
//
//
//    /*
//    sort it, then check the characters if they are two, then two, then two, with allowing one to also be one.
//    or, check that there is no odds except for one if necessary
//     */
//    }
//    boolean isPermutationOfPalindrome(String phrase) {
//        int countOdd
//    }

}
