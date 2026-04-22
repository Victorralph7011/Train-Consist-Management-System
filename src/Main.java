public class Main {

    // --- Restored classes to keep UC8-UC14 tests compiling ---
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
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    public static class PassengerBogie {
        public String type;
        public int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }
    // ---------------------------------------------------------

    // ---- CUSTOM RUNTIME EXCEPTION ----
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model with assignment logic
    public static class GoodsBogie {
        public String type; // Kept for UC12 legacy tests
        public String shape;
        public String cargo;

        // Legacy constructor for UC12
        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.shape = type;
            this.cargo = cargo;
        }

        // New constructor for UC15
        public GoodsBogie(String shape) {
            this.shape = shape;
            this.type = shape;
        }

        // Assign cargo with safety validation
        public void assignCargo(String newCargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if ("Rectangular".equalsIgnoreCase(this.shape) && "Petroleum".equalsIgnoreCase(newCargo)) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = newCargo;
                System.out.println("Cargo assigned successfully -> " + newCargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie\n");
            }
        }

        @Override
        public String toString() {
            return shape + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC15 - Safe Cargo Assignment");
        System.out.println("==================================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("UC15 runtime handling completed...");
    }
}