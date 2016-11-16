package PhiAndSeries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class SetComparer {
    private static Hashtable<Integer, HashSet<Integer>> seriesModN;
    private static Hashtable<Integer, HashSet<Integer>> seriesPhiNumbers;
    private static Hashtable<Integer, HashSet<Integer>> seriesPhiNumbers1Mod4;
    private static Hashtable<Integer, HashSet<Integer>> seriesPhiNumbers3Mod4;

    List<Integer> seriesPhiMatches = new ArrayList<>();
    List<Integer> seriesPhi1Mod4Matches = new ArrayList<>();
    List<Integer> seriesPhi3Mod4Matches = new ArrayList<>();


    public static void compareModsToPhiValues(Hashtable<Integer, HashSet<Integer>>... arguments) {
        instantiateFields(arguments);
        System.out.println("comparing results");
        compare();
        printResults();
    }


    private static void instantiateFields(Hashtable<Integer, HashSet<Integer>>... arguments) {
        seriesModN = arguments[0];
        seriesPhiNumbers = arguments[1];
        seriesPhiNumbers1Mod4 = arguments[2];
        seriesPhiNumbers3Mod4 = arguments[3];
    }

    private static void compare() {
        int number;
        HashSet<Integer> set;
        for (int i : seriesModN.keySet()) {
            System.out.println("--Number" + i);
            set = seriesModN.get(i);
            if (!isPhiValuesLargerThanModNumbers(i)) {

            }
        }
    }

    private static boolean isPhiValuesLargerThanModNumbers(int i) {
        return seriesPhiNumbers.get(i).size() > seriesModN.get(i).size();
    }

    private static void printResults() {
    }

}
