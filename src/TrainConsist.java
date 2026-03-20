package com.train.management;

import java.util.ArrayList;
import java.util.List;

public class TrainConsist {
    private List<Bogie> bogies;

    public TrainConsist() {
        this.bogies = new ArrayList<>();
    }

    public void displayConsist() {
        System.out.println("Train Consist Summary:");
        if (bogies.isEmpty()) {
            System.out.println("No bogies in the consist.");
        } else {
            for (Bogie bogie : bogies) {
                System.out.print(bogie + " ");
            }
            System.out.println("\nTotal Bogies: " + bogies.size());
        }
    }
}