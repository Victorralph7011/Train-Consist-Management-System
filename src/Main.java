import java.util.ArrayList;
import java.util.List;

public class Main {

    // --- Restored Bogie class so earlier tests compile ---
    public static class Bogie {
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
    // -----------------------------------------------------

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("==================================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // This will cause a safety violation

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : goodsBogies) {
            System.out.println(bogie);
        }
        System.out.println();

        // Check compliance using allMatch()
        // Rule: If the type is Cylindrical, the cargo MUST be Petroleum.
        boolean isSafe = goodsBogies.stream()
                .allMatch(bogie -> bogie.type.equals("Cylindrical") ? bogie.cargo.equals("Petroleum") : true);

        // Display safety status
        System.out.println("Safety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }
        System.out.println("\nUC12 safety validation completed...");
    }
}