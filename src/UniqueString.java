import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raphael on 10/30/2016.
 */
public class UniqueString {
    public static boolean isAllCharactersUnique(String s) {
        Set<Integer> characters = new HashSet<>();
        int x;
        for (int i = 0; i < s.length(); i++) {

            x = s.charAt(i);
            System.out.println(x);
            if (characters.contains(x)) {
                return false;
            } else {
                characters.add(x);
            }
        }
        return true;
    }

    public boolean isUniqueChars(String string) {
        int checker = 0;

        for (int i = 0; i < string.length(); i++) {

            int val = string.charAt(i) - 'a';

            if ((checker & (1 << val)) > 0) {

                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }
}
