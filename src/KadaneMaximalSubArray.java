/**
 * Created by Raphael on 11/14/2016.
 */
public class KadaneMaximalSubArray {

    public static int localMax(int[] full, int sublength) {
        int sum = 0;
        int max = 0;
        for (int i = sublength; i >= 0; i--) {
            sum = sum + full[i];
            if (sum > max) {
                max = sum;
            }
        }
        sum = 0;
        return max;
    }

    public static int splitArr(int[] full) {
        int sum_final = 0;
        int max_final = 0;
        for (int j = 0; j < full.length; j++) {
            sum_final = localMax(full, j);
            if (sum_final > max_final) {
                max_final = sum_final;
            }
        }

        return max_final;
    }
}
