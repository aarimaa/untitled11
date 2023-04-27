package org.example;

import java.util.Arrays;

public class Farm {
    private String title;
    private String[] animals;
    private double[] weights;

    public Farm(String title, String[] animals, double[] weights) {
        this.title = title;
        this.animals = animals;
        this.weights = weights;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAnimals() {
        return animals;
    }

    public double[] getWeights() {
        return weights;
    }

    @Override
    public Farm clone() {
        try {
            Farm cloned = (Farm) super.clone();
            cloned.animals = Arrays.copyOf(this.animals, this.animals.length);
            cloned.weights = Arrays.copyOf(this.weights, this.weights.length);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
