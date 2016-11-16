package PhiAndSeries;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class SeriesBuilder {
    public static int[] getSeries(int amount, int power) {
        int[] series = new int[amount];

        for (int i = 0; i < amount; i++) {
            int a = ((int) Math.pow(((double) i), ((double) power)));
            int b = ((int) Math.pow(((double) (i + 1)), ((double) power)));
            series[i] = a + b;
        }

        return series;
    }

    private static Set<Integer> getModsOfNumber(int[] series, int mod) {
        HashSet<Integer> mods = new HashSet<>();
        for (int i : series) {
            mods.add(i % mod);

        }
        return mods;
    }

    public static Set<Integer> getModsOfNumber(HashSet<Integer> series, int mod) {
        HashSet<Integer> mods = new HashSet<>();
        Iterator iterator = series.iterator();
        while (iterator.hasNext()) {
            mods.add(((Integer) iterator.next()) % mod);
        }
        return mods;
    }


    private static Set<Integer> getNMod4Numbers(int n, Set<Integer> numbers) {
        HashSet<Integer> results = new HashSet<>();

        Iterator iterator = numbers.iterator();

        while (iterator.hasNext()) {
            int i = (Integer) iterator.next();
            if (i % 4 == n) {
                results.add(i);
            }
        }
        return results;
    }

    public static Hashtable<Integer, HashSet<Integer>> getAllMods(int[] series, int upperBound) {
        Hashtable<Integer, HashSet<Integer>> results = new Hashtable<>();
        for (int i = 0; i < upperBound; i++) {
            results.put(i, (HashSet<Integer>) getModsOfNumber(series, i));
        }
        return results;
    }

    public static Hashtable<Integer, HashSet<Integer>> getAllPhiValues(int[] series) {
        Hashtable<Integer, HashSet<Integer>> results = new Hashtable<>();

        for (int i : series) {
            results.put(i, (HashSet<Integer>) PhiFunction.getPhiValues(i));
        }
        return results;
    }

    public static Hashtable<Integer, HashSet<Integer>> getPhiValuesNMod4(int n, int[] series, Hashtable<Integer, HashSet<Integer>> table) {
        Hashtable<Integer, HashSet<Integer>> results = new Hashtable<>();
        for (int i = 0; i < series.length; i++) {
            results.put(series[i], (HashSet<Integer>) getNMod4Numbers(4, table.get(series[i])));
        }
        return results;
    }
}
