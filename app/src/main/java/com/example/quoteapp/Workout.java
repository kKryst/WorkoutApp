package com.example.quoteapp;

import java.util.ArrayList;
public class Workout {

    private String name;
    private ArrayList<Step> steps;

    public Workout(String name, ArrayList<Step> steps) {
        this.name = name;
        this.steps = steps;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public static class Step {
        private int step;
        private String description;

        public Step(int step, String description) {
            this.step = step;
            this.description = description;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}



