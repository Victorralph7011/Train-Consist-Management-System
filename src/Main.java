public class Main {

    // --- Restored classes to keep UC8-UC13 tests compiling happily ---
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

    public static class GoodsBogie {
        public String type;
        public String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }
    // -----------------------------------------------------------------

    // ---- CUSTOM EXCEPTION ----
    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    public static class PassengerBogie {
        public String type;
        public int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            // Fail-fast validation
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity");
        System.out.println("==================================================\n");

        try {
            // 1. Create a valid bogie
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + validBogie);

            // 2. Attempt to create an invalid bogie (this will throw an exception)
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);

            // This line won't execute because the exception jumps to the catch block
            System.out.println("Created Bogie: " + invalidBogie);

        } catch (InvalidCapacityException e) {
            // Catch and display the custom error message
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}