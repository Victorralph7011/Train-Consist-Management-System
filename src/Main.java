import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Reusing Bogie model from UC7
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
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("======================================");
        System.out.println();

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();

        // Convert list into stream, apply filter, and collect results
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie bogie : filteredBogies) {
            System.out.println(bogie);
        }
        System.out.println();

        System.out.println("UC8 filtering completed...");
    }
}