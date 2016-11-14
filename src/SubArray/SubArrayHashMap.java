package SubArray;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Raphael on 11/14/2016.
 */
public class SubArrayHashMap {

    public boolean isSubArrayInArray(int[]key, int[]book){
        HashMap hashmap = new HashMap();
        int value = 0;

        for (int i = 0; i <  book.length - (key.length - 1); i++) {
            int[]arrayToBeHashed = new int[key.length];

            for (int j = 0; j < key.length; j++) {
                arrayToBeHashed[j] = book[i + j];
            }
            hashmap.put(Arrays.hashCode(arrayToBeHashed), value++);
        }

        if (hashmap.get(Arrays.hashCode(key)) != null) {
            return true;
        } else {
            return false;
        }
    }
}
