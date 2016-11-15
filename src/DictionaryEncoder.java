import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Raphael on 11/14/2016.
 */
public class DictionaryEncoder {

    // WARNING - Still In Progress!!!

    HashMap<Integer, String> dictionary;
    List<Integer> code;
    int counter;

    public void encode(String string) {
        dictionary = new HashMap<>();
        code = new ArrayList<>();
        counter = 0;

        String zig = string.substring(0, 1);
//        code.add(counter);
//        dictionary.put(counter++, zig);

        String wig;
        for (int i = 1; i < string.length(); i++) {
            wig = string.substring(i, i + 1);

            String zigwig = zig + wig;

            if (dictionary.containsValue(zigwig)){
                zig = zigwig;
//                code.remove(code.size());
            } else {
                code.add(counter);
                dictionary.put(counter++, zigwig);
                zig = wig;
            }

        }


        dictionary.values().stream().forEach(System.out::println);
        code.stream().forEach(System.out::println);
    }

    public String decode(List<Integer> code) {
        String string = "";
        for (int i = 0; i < code.size(); i++) {
            string += dictionary.get(code.get(i));
        }
        return string;
    }
}
