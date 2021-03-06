package Genetics;

import java.util.Arrays;

/**
 *
 * @author rgal
 */
public class Knapsack {
    private boolean[] chromosome;
    private int totalWeight;
    private int totalValue;
    
    public Knapsack(boolean[] chromosome) {
        this.chromosome = chromosome;
        totalWeight = 0;
        totalValue = 0;
    }

    public boolean[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(boolean[] chromosome) {
        this.chromosome = chromosome;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }


    @Override
    public String toString() {
        return "Knapsack{" +
                "chromosome=" + Arrays.toString(chromosome) +
                ", totalWeight=" + totalWeight +
                ", totalValue=" + totalValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knapsack knapsack = (Knapsack) o;

        if (totalWeight != knapsack.totalWeight) return false;
        if (totalValue != knapsack.totalValue) return false;
        return Arrays.equals(chromosome, knapsack.chromosome);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(chromosome);
        result = 31 * result + totalWeight;
        result = 31 * result + totalValue;
        return result;
    }
}
