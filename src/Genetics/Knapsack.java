/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetics;

import java.util.Arrays;

/**
 *
 * @author rgal
 */
public class Knapsack {
    private int chromosome[];
    private int totalWeight;
    private int totalValue;
    
    public Knapsack(int chromosome[]) {
        this.chromosome = chromosome;
        totalWeight = 0;
        totalValue = 0;
    }

    public int[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(int chromosome[]) {
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
