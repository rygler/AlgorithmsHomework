package Genetics;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author rgal
 */
public class Genetic {

    private Item[] items;
    private Knapsack[] knapsacks;
    private int generation = 1;
    private int numberOfGenerations;

    public Genetic(int numberOfItems, int numberOfKnapsacks, int numberOfGenerations) {
        items = new Item[numberOfItems];
        knapsacks = new Knapsack[numberOfKnapsacks];
        this.numberOfGenerations = numberOfGenerations;

        generateRandomItems(numberOfItems);
        for (Item item : items) {
            System.out.println(item);
        }

        // generate initial knapsacks
        generateKnapsacks();

        runEvolution();
    }

    private void generateRandomItems(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            int weight = ThreadLocalRandom.current().nextInt(11);
            int value = ThreadLocalRandom.current().nextInt(101);

            Item item = new Item(weight, value);
            items[i] = item;
        }
    }

    private void generateKnapsacks() {
        for (int i = 0; i < knapsacks.length; i++) {
            int chromosome[] = new int[items.length];

            for (int j = 0; j < chromosome.length; j++) {
                if (ThreadLocalRandom.current().nextDouble() < 0.1) {
                    chromosome[j] = 1;
                } else {
                    chromosome[j] = 0;
                }

                knapsacks[i] = new Knapsack(chromosome);
            }

        }
    }

    private void runEvolution() {
        // Main loop
        while (generation <= numberOfGenerations) {
            System.out.println("==================================");
            System.out.println("Begin generation: " + generation);
            System.out.println("==================================");

            int valueSum = 0;
            int bestValue = 0;
            int bestKnapsack = 0;
            int maxWeight = 50;

            // Calculate value and weight
            for (int index = 0; index < knapsacks.length; index++) {
                int totalWeight = 0;
                int totalValue = 0;

                for (int geneIndex = 0; geneIndex < knapsacks[index].getChromosome().length; geneIndex++) {
                    int gene = knapsacks[index].getChromosome()[geneIndex];
                    if (gene == 1) {
                        totalWeight += items[geneIndex].getWeight();
                        totalValue += items[geneIndex].getValue();
                    }
                }

                if (isWeightUnderMaxWeight(totalWeight)) {
                    if (totalValue > bestValue) {
                        bestValue = totalValue;
                        bestKnapsack = index;
                    }
                } else {
                    totalValue = 0;
                }

                knapsacks[index].setTotalWeight(totalWeight);
                knapsacks[index].setTotalValue(totalValue);
                valueSum += totalValue;
            }

            // Use Roulette wheel algorithm to proportionately create next generation
            Knapsack[] newGeneration = new Knapsack[knapsacks.length];
            Knapsack elitist = new Knapsack(Arrays.copyOf(knapsacks[bestKnapsack].getChromosome(), knapsacks[bestKnapsack].getChromosome().length));
            elitist.setTotalValue(knapsacks[bestKnapsack].getTotalValue());
            elitist.setTotalWeight(knapsacks[bestKnapsack].getTotalWeight());
            System.out.println("Elitist: " + bestKnapsack);
            System.out.println(elitist.toString());

            for (int i = 0; i < knapsacks.length - 1; i++) {
                double random = ThreadLocalRandom.current().nextDouble();
                double randomSum = 0;
                int randomSelected = 0;

                for (int j = 0; j < knapsacks.length - 1; j++) {
                    double relativeValue = knapsacks[j].getTotalValue() / valueSum;
                    randomSum += relativeValue;
                    if (randomSum > random) {
                        break;
                    } else {
                        randomSelected++;
                    }
                }

                newGeneration[i] = new Knapsack(ArrayUtils.clone(knapsacks[randomSelected].getChromosome()));
            }

            // Replace old generation with new
            knapsacks = newGeneration;
            generation += 1;

            // Randomly select two knapsacks
            int randomKnapsack1 = ThreadLocalRandom.current().nextInt(knapsacks.length - 1);
            int randomKnapsack2 = randomKnapsack1;

            while (randomKnapsack1 == randomKnapsack2) {
                randomKnapsack2 = ThreadLocalRandom.current().nextInt(knapsacks.length - 1);
            }

            // Perform Crossover
            int splitPoint = ThreadLocalRandom.current().nextInt(knapsacks.length - 1);
            int[] front1 = Arrays.copyOfRange(knapsacks[randomKnapsack1].getChromosome(), 0, splitPoint);
            int[] front2 = Arrays.copyOfRange(knapsacks[randomKnapsack2].getChromosome(), 0, splitPoint);
            int[] back1 = Arrays.copyOfRange(knapsacks[randomKnapsack1].getChromosome(), splitPoint, items.length);
            int[] back2 = Arrays.copyOfRange(knapsacks[randomKnapsack2].getChromosome(), splitPoint, items.length);

            int[] newChromosome1 = ArrayUtils.addAll(front1, back2);
            int[] newChromosome2 = ArrayUtils.addAll(front2, back1);

            knapsacks[randomKnapsack1] = new Knapsack(newChromosome1);
            knapsacks[randomKnapsack2] = new Knapsack(newChromosome2);

            // Perform mutation
//            for (Knapsack knapsack : knapsacks) {
            for (int i = 0; i < knapsacks.length - 1; i++) {


                for (int j = 0; j < knapsacks[i].getChromosome().length; j++) {
                    if (ThreadLocalRandom.current().nextDouble() < 0.01) {
                        System.out.println("Successful mutation at gene: " + j);

                        int gene = knapsacks[i].getChromosome()[j];

                        gene = gene == 0 ? 1 :  0;

                        knapsacks[i].getChromosome()[j] = gene;
                    }
                }
            }

            knapsacks[knapsacks.length - 1] = elitist;

            System.out.println("Last knapsack: " + knapsacks[knapsacks.length - 1].toString());
            System.out.println("Best value: " + bestValue);
        }
    }

    private boolean isWeightUnderMaxWeight(int totalWeight) {
        int maxWeight = 50;
        return totalWeight <= maxWeight;
    }

}
