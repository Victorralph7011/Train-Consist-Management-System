import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("======================================");
        System.out.println();

        // Create a LinkedList to maintain insertion order and allow fast inserts
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        System.out.println();

        // Insert a Pantry Car at position 2
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);
        System.out.println();

        // Remove the first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("UC4 ordered consist operations completed...");
    }
}