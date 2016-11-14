import java.util.Arrays;

/**
 * Created by Raphael on 9/13/2016.
 */
public class SubArrayMatcher {
    public static boolean isSubArrayInArray(int[] subArray, int[] array) {
        int subArrayHash = Arrays.hashCode(subArray);
        System.out.println(subArrayHash);

        for (int i = 0; i < array.length - subArray.length; i++) {
            System.out.println(Arrays.hashCode(Arrays.copyOfRange(array, i, i + subArray.length)));
            if (subArrayHash == Arrays.hashCode(Arrays.copyOfRange(array, i, i + subArray.length))) {
                return true;
            }
        }
        return false;
    }
    /*
    Try putting everything into a hashmap and then checking your hash
     */
}
