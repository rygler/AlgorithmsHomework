package SubArray;

import java.util.Arrays;

public class SubArrayForLoop {

    public static boolean isSubArrayInArray(int[] subArray, int[] array) {
        
        int subArrayHash = Arrays.hashCode(subArray);

        for (int i = 0; i < array.length - subArray.length; i++) {

            if (subArrayHash == Arrays.hashCode(Arrays.copyOfRange(array, i, i + subArray.length))) {
                return true;
            }
        }
        return false;
    }
}
