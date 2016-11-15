import java.util.Arrays;

/**
 * Created by Raphael on 11/14/2016.
 */
public class HornersRule {
    public static int calculate_hash(String s, int xValue) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        String newS = new String(array);
        int hashValue = 0;
        for (int i = 0; i < newS.length(); i++) {
            hashValue = xValue * hashValue + newS.charAt(i);
        }
        return hashValue;
    }
}
