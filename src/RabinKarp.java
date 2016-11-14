import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Raphael on 11/14/2016.
 */
public class RabinKarp {
    private String pattern;
    private long patternHashValue;
    private int patternLength;
    private long largePrime;
    private int radix;
    private long RM;

    public RabinKarp(String txt, String pat)
    {
        this.pattern = pat;
        radix = 256;
        patternLength = pat.length();
        largePrime = longRandomPrime();
        /** precompute R^(M-1) % Q for use in removing leading digit **/
        RM = 1;
        for (int i = 1; i <= patternLength-1; i++)
            RM = (radix * RM) % largePrime;
        patternHashValue = hash(pat, patternLength);
        int posision = search(txt);
        if (posision == -1)
            System.out.println("\nNo Match\n");
        else
            System.out.println("Pattern found at position : "+ posision);
    }
    /** Compute hash **/
    private long hash(String key, int M)
    {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (radix * h + key.charAt(j)) % largePrime;
        return h;
    }
    /** Function check **/
    private boolean check(String txt, int i)
    {
        for (int j = 0; j < patternLength; j++)
            if (pattern.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }
    /** Function to check for exact match**/
    private int search(String text)
    {
        int N = text.length();
        if (N < patternLength) return N;
        long textHash = hash(text, patternLength);
        /** check for match at start **/
        if ((patternHashValue == textHash) && check(text, 0))
            return 0;
        /** check for hash match. if hash match then check for exact match**/
        for (int i = patternLength; i < N; i++)
        {
            // Remove leading digit, add trailing digit, check for match.
            textHash = (textHash + largePrime - RM * text.charAt(i - patternLength) % largePrime) % largePrime;
            textHash = (textHash * radix + text.charAt(i)) % largePrime;
            // match
            int offset = i - patternLength + 1;
            if ((patternHashValue == textHash) && check(text, offset))
                return offset;
        }
        /** no match **/
        return -1;
    }
    /** generate a random 31 bit prime **/
    private static long longRandomPrime()
    {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
