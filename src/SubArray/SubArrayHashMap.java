package SubArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Raphael on 11/14/2016.
 */
public class SubArrayHashMap {

    public boolean isSubArrayInArray(int[] subArray, int[] array){

        Map hashmap = new HashMap();
        int value = 0;

        for (int i = 0; i <  array.length - (subArray.length - 1); i++) {
            int[]arrayToBeHashed = new int[subArray.length];

            for (int j = 0; j < subArray.length; j++) {
                arrayToBeHashed[j] = array[i + j];
            }
            hashmap.put(Arrays.hashCode(arrayToBeHashed), value++);
        }

        if (hashmap.get(Arrays.hashCode(subArray)) != null) {
            return true;
        } else {
            return false;
        }
    }
}
