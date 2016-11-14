package HashMaps;

import java.util.Arrays;

/**
 * Created by Raphael on 11/14/2016.
 */
public class HashMapsQuadraticProbe {
    int[] backingArray;

    public HashMapsQuadraticProbe(int... numbers) {
        backingArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int index = getHashIndex(numbers[i]);

            backingArray[index] = numbers[i];

            System.out.println("----------------------");
            System.out.println("round " + i);
            Arrays.stream(backingArray).forEach(System.out::println);
        }
    }

    private int getHashIndex(int number) {
        int index;
        int c1 = 1, c2 = 2;

        for (int i = 0; i < backingArray.length; i++) {
            index = ((number + c1 * i + c2 * ((int) Math.pow(i, 2)))) % (backingArray.length);
            if (backingArray[index] == 0) {
                return index;
            }
        }

        return -1;
    }
}

