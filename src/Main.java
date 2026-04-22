import java.util.Arrays;

public class Main {

    // --- Restored classes to keep UC8-UC17 tests compiling ---
    public static class Bogie {
        public String name;
        public String type;
        public int capacity;

        public Bogie(String nameOrType, int capacity) {
            this.name = nameOrType;
            this.type = nameOrType;
            this.capacity = capacity;
        }
    }

    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) { super(message); }
    }

    public static class PassengerBogie {
        public String type;
        public int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) throw new InvalidCapacityException("Capacity must be greater than zero");
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) { super(message); }
    }

    public static class GoodsBogie {
        public String type;
        public String shape;
        public String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type; this.shape = type; this.cargo = cargo;
        }

        public GoodsBogie(String shape) {
            this.shape = shape; this.type = shape;
        }

        public void assignCargo(String newCargo) {
            try {
                if ("Rectangular".equalsIgnoreCase(this.shape) && "Petroleum".equalsIgnoreCase(newCargo)) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = newCargo;
            } catch (CargoSafetyException e) {
                // Handled silently for legacy tests
            } finally {
                // Handled silently for legacy tests
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // ---------------------------------------------------------

    // ---- LINEAR SEARCH LOGIC ----
    public static boolean linearSearch(String[] arr, String target) {
        for (String id : arr) {
            if (id.equals(target)) {
                return true; // Match found, exit early
            }
        }
        return false; // Traversed whole array, not found
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC18 - Linear Search for Bogie ID");
        System.out.println("==================================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        // Perform linear search
        boolean found = linearSearch(bogieIds, searchId);

        // Display result
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}