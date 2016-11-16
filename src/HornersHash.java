import java.util.Arrays;

public class HornersHash {

    public static int calculateHash(String s, int x) {

        char[] array = s.toCharArray();
        Arrays.sort(array);
        String newString = new String(array);
        int hashValue = 0;

        for (int i = 0; i < newString.length(); i++) {
            hashValue = x * hashValue + newString.charAt(i);
        }

        return hashValue;
    }
}
