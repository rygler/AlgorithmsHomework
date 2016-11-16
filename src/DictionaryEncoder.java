import java.util.HashMap;
import java.util.Map;

public class DictionaryEncoder {

    private Map<Integer, String> dictionary;
    private int counter;

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

        dictionary.values().forEach(System.out::println);
    }
}
