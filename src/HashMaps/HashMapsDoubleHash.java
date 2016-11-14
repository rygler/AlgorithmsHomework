package HashMaps;

import java.util.Arrays;

/**
 * Created by Raphael Gal on 11/7/2016.
 */
public class HashMapsDoubleHash {
    int[] backingArray;

    public HashMapsDoubleHash(int... numbers) {
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

        for (int i = 0; i < backingArray.length; i++) {
            index = (hashOne(number) + i * hashTwo(number)) % (backingArray.length);
            if (backingArray[index] == 0) {
                return index;
            }
        }

        return -1;
    }


    private int hashOne(int number) {
        return number % backingArray.length;
    }

    private int hashTwo(int number) {
        return (int) Math.floor((number + 1) / 2) % backingArray.length;
    }
}
