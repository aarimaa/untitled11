package org.example;

import java.util.Scanner;

public class Main {
    private static final Farm[] farms = {
            new Farm("Farm 1", new String[]{"cow", "cow", "pig", "pig", "pig"}, new double[]{500, 550, 200, 250, 280}),
            new Farm("Farm 2", new String[]{"cow", "cow", "cow", "cow", "cow"}, new double[]{550, 550, 550, 550, 550}),
            new Farm("Farm 3", new String[]{"pig", "pig", "pig", "pig", "pig"}, new double[]{200, 220, 240, 260, 280}),
            new Farm("Farm 4", new String[]{"cow", "cow", "cow", "cow", "pig"}, new double[]{450, 500, 550, 600, 220}),
            new Farm("Farm 5", new String[]{"cow", "pig", "pig", "pig", "pig"}, new double[]{500, 250, 270, 290, 310})
    };

    public static void main(String[] args) {
        zapitA();
        zapitB();
    }

    public static void zapitA() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the carrying capacity of the truck: ");
        double carryingCapacity = scanner.nextDouble();
        scanner.close();
        boolean canLoad = false;
        for (Farm farm : farms) {
            String[] animals = farm.getAnimals();
            double[] weights = farm.getWeights();
            double totalWeight = 0;
            String animal = null;
            for (int i = 0; i < animals.length; i++) {
                if (animal == null) {
                    animal = animals[i];
                } else if (!animal.equals(animals[i])) {
                    System.out.println("The animals on " + farm.getTitle() + " farm are not the same!");
                    break;
                }
                totalWeight += weights[i];
            }
            if (totalWeight <= carryingCapacity) {
                canLoad = true;
                System.out.println("Load " + totalWeight + "kg of " + animal + " on " + farm.getTitle() + " farm");
            }
        }
        if (!canLoad) {
            System.out.println("The carrying capacity is too small to load any farm!");
        }
    }

    public static void zapitB() {
        String[] animals = farms[0].getAnimals();
        for (String animal : animals) {
            boolean existsInAllFarms = true;
            for (Farm farm : farms) {
                if (!containsAnimal(farm.getAnimals(), animal)) {
                    existsInAllFarms = false;
                    break;
                }
            }
            if (existsInAllFarms) {
                System.out.println("The animal \"" + animal + "\" exists in all farms.");
            } else {
                System.out.println("The animal \"" + animal + "\" does not exist in all farms.");
            }
        }
    }
    private static boolean containsAnimal(String[] animals, String animal) {
        for (String a : animals) {
            if (a.equals(animal)) {
                return true;
            }
        }
        return false;
    }
}