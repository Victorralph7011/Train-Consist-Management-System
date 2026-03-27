import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // --- Restored Passenger Bogie (Compatible with UC8, UC9, UC10, and UC13 tests) ---
    public static class Bogie {
        public String name;
        public String type; // Alias to keep UC13 tests happy
        public int capacity;

        public Bogie(String nameOrType, int capacity) {
            this.name = nameOrType;
            this.type = nameOrType;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // --- Restored Goods Bogie (Compatible with UC12 tests) ---
    public static class GoodsBogie {
        public String type;
        public String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }
    // -------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("==================================================\n");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
        }

        // --- MEASURE LOOP PERFORMANCE ---
        long loopStartTime = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long loopEndTime = System.nanoTime();
        long loopDuration = loopEndTime - loopStartTime;

        // --- MEASURE STREAM PERFORMANCE ---
        long streamStartTime = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;

        // Display performance results
        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);
        System.out.println("\nUC13 performance benchmarking completed...");
    }
}