import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Raphael on 11/14/2016.
 */
public class DictionaryEncoder {
    HashMap<Integer, String> dictionary;
    List<Integer> code;
    int counter = 0;

    public void encode(String string) {
        dictionary = new HashMap<>();
        code = new ArrayList<>();

        String zig = string.substring(0, 1);
        code.add(counter);
        dictionary.put(counter++, zig);
        String wig;
//        for (int i = 0; i < string.length(); i++) {
//            zig = string.substring(i, i + 1);
//            for (int j = i + 1; j < string.length(); j++) {
//                String wig = string.substring(i, j);
//                if (!dictionary.containsValue(wig)) {
//                    dictionary.put(counter++, wig);
//                }
//            }
//        }
        for (int i = 1; i < string.length(); i++) {
            wig = string.substring(i, i + 1);

            String zigwig = zig + wig;

            if (dictionary.containsValue(zigwig)){
                zig = zigwig;
            } else {
                code.add(counter);
                dictionary.put(counter++, zigwig);
                zig = wig;
            }
        }

        for (int i = 0; i < code.size(); i++) {
            System.out.println(code.get(i) + ": " + dictionary.get(code.get(i)));
        }
        dictionary.values().stream().forEach(System.out::println);
    }

//    public String decode() {
//
//    }
}
