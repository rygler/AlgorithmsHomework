/**
 * Created by Raphael on 11/14/2016.
 */
public class KadaneMaximalSubArray {

    public static int largestSubValues(int[]array){
        int maxSoFar = 0;
        int maxIfEndNow = 0;
        for (int i = 0; i < array.length ; i++) {
            maxIfEndNow += array[i];

            if(maxIfEndNow > maxSoFar){
                maxSoFar = maxIfEndNow;
            }
        }
        return maxSoFar;
    }
}
