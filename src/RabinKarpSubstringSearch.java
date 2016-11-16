import java.math.BigInteger;
import java.util.Random;

public class RabinKarpSubstringSearch {
    private String pattern;
    private long patternHashValue;
    private int patternLength;
    private long largePrime;
    private int radix;
    private long RM;

    public RabinKarpSubstringSearch(String string, String pattern) {

        this.pattern = pattern;
        radix = 256;
        patternLength = pattern.length();
        largePrime = longRandomPrime();

        RM = 1;
        for (int i = 1; i <= patternLength - 1; i++) {
            RM = (radix * RM) % largePrime;
        }

        patternHashValue = hash(pattern, patternLength);

        int position = search(string);

        if (position == -1) {
            System.out.println("No Match");
        } else {
            System.out.println("Pattern found at position : " + position);
        }
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (radix * h + key.charAt(i)) % largePrime;
        }
        return h;
    }

    private boolean check(String txt, int i) {

        for (int j = 0; j < patternLength; j++) {
            if (pattern.charAt(j) != txt.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    private int search(String text) {
        int N = text.length();
        if (N < patternLength) {
            return N;
        }

        long textHash = hash(text, patternLength);

        if ((patternHashValue == textHash) && check(text, 0)) {
            return 0;
        }

        for (int i = patternLength; i < N; i++) {
            textHash = (textHash + largePrime - RM * text.charAt(i - patternLength) % largePrime) % largePrime;
            textHash = (textHash * radix + text.charAt(i)) % largePrime;

            int offset = i - patternLength + 1;
            if ((patternHashValue == textHash) && check(text, offset)) {
                return offset;
            }
        }

        return -1;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
