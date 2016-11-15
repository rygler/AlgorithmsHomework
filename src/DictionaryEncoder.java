import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Raphael on 11/14/2016.
 */
public class DictionaryEncoder {

    Map<Integer, String> dictionary;
    int counter;

    public void encode(String string) {
        dictionary = new HashMap<>();
        char c;

        for (int i = 32; i < 127; i++) {
            c = (char) i;
            dictionary.put(i - 32, String.format("%s", c));
        }

        counter = 128 - 32;

        String s = "";

        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);

            if (dictionary.containsValue(s + c)) {
                s = s + c;
            } else {
                dictionary.put(counter++, s + c);
                s = c + "";
            }
        }

        dictionary.values().stream().forEach(System.out::println);
    }
}
