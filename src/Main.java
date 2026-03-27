import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("======================================");
        System.out.println();

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();

        // Sort using Comparator logic (Lambda expression)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("After Sorting by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();

        System.out.println("UC7 sorting completed...");
    }
}