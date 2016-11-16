package HashMaps;

import java.util.Arrays;

public class HashMapsLinearProbe {
    private int[] backingArray;

    public HashMapsLinearProbe(int... numbers) {
        backingArray = new int[numbers.length];
        int index;

        for (int number : numbers) {
            index = getHashIndex(number);
            backingArray[index] = number;
        }
    }

    private int getHashIndex(int number) {
        int index;

        for (int i = 0; i < backingArray.length; i++) {
            index = ((number % backingArray.length) + i) % backingArray.length;
            if (backingArray[index] == 0) {
                return index;
            }
        }
        return -1;
    }


}
