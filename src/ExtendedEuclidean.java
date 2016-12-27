/**
 * Created by Raphael on 12/26/2016.
 */
public class ExtendedEuclidean {

    /*
    Returns an array where the first element is the GCD, the second is the coefficient of a, and the third is the
    coefficient of b.
     */
    public static int[] extendedEuclidean(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Both values cannot be 0!");
        }

        a = Math.abs(a);
        b = Math.abs(b);

        int[] result = new int[3];
        int q;

        if (b == 0) {
            result[0] = a;
            result[1] = 1;
            result[2] = 0;
        } else {
            q = a / b;
            result = extendedEuclidean(b, a % b);
            int temp = result[1] - result[2] * q;
            result[1] = result[2];
            result[2] = temp;
        }

        return result;
    }
}
