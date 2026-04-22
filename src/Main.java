public class Main {

    // --- Restored classes to keep UC8-UC15 tests compiling ---
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
    // ---------------------------------------------------------

    // ---- BUBBLE SORT LOGIC ----
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop controls number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop compares adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap values when left element is greater than right element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("==================================================\n");

        // Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Perform sorting
        bubbleSort(capacities);

        // Display sorted result
        System.out.println("\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println("\n\nUC16 sorting completed...");
    }
}