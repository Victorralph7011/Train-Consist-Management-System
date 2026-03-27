import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    // --- Restored Bogie class so UC8, UC9, and UC10 tests can compile ---
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
    // -------------------------------------------------------------------

    public static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    public static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code");
        System.out.println("==================================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        Pattern trainPattern = Pattern.compile(TRAIN_ID_REGEX);
        Pattern cargoPattern = Pattern.compile(CARGO_CODE_REGEX);

        boolean isTrainValid = trainPattern.matcher(trainId).matches();
        boolean isCargoValid = cargoPattern.matcher(cargoCode).matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);
        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}