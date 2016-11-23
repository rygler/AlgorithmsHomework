public class KadaneMaximalSubArray {

    public static void findMaxSubArray(int[] inputArray) {

        int maxSum = Integer.MIN_VALUE;

        int cumulativeSum = 0;

        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

            int eachArrayItem = inputArray[currentIndex];

            cumulativeSum += eachArrayItem;

            if (cumulativeSum > maxSum) {
                System.out.println(cumulativeSum);
                maxSum = cumulativeSum;
            } else if (cumulativeSum < 0) {
                cumulativeSum = 0;
            }
        }

        System.out.println("Max sum: " + maxSum);

    }
}
