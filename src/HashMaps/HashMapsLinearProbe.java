package HashMaps;

import java.util.Arrays;

/**
 * Created by Raphael Gal on 11/7/2016.
 */
public class HashMapsLinearProbe {
    int[] backingArray;

    public HashMapsLinearProbe(int... numbers) {
        backingArray = new int[numbers.length];
        int index;

        for (int i = 0; i < numbers.length; i++) {

            index = getHashIndex(numbers[i]);

            backingArray[index] = numbers[i];

            System.out.println("----------------------");
            System.out.println("round " + i);
            Arrays.stream(backingArray).forEach(System.out::println);
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
