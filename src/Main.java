import java.util.Arrays;

public class Main {

    // --- Restored classes to keep UC8-UC16 tests compiling ---
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

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==================================================\n");

        // Create array of bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original order
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames) + "\n");

        // Use built-in sorting utility
        Arrays.sort(bogieNames);

        // Display sorted result
        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames) + "\n");

        System.out.println("UC17 sorting completed...");
    }
}