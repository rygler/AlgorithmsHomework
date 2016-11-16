import java.util.HashSet;
import java.util.Set;

public class UniqueString {

    public static boolean isUniqueChars(String string) {
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
