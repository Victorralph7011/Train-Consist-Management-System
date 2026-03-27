import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase10TrainConsistMgmtTest {

    // Helper method to simulate the reduce logic
    private int calculateTotalSeats(List<Main.Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("AC Chair", 56),
                new Main.Bogie("First Class", 24),
                new Main.Bogie("Sleeper", 70)
        );
        int totalSeats = calculateTotalSeats(bogies);
        assertEquals(222, totalSeats); // 72 + 56 + 24 + 70 = 222
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("General", 90),
                new Main.Bogie("General", 90)
        );
        int totalSeats = calculateTotalSeats(bogies);
        assertEquals(180, totalSeats);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("First Class", 24)
        );
        int totalSeats = calculateTotalSeats(bogies);
        assertEquals(24, totalSeats);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Main.Bogie> bogies = new ArrayList<>();
        int totalSeats = calculateTotalSeats(bogies);
        assertEquals(0, totalSeats); // The identity value should be returned
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // This test inherently checks if map() works by verifying the sum is purely based on the capacity field
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Engine", 0), // Assuming engine holds 0 passengers
                new Main.Bogie("Sleeper", 72)
        );
        int totalSeats = calculateTotalSeats(bogies);
        assertEquals(72, totalSeats);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("A", 10),
                new Main.Bogie("B", 10),
                new Main.Bogie("C", 10),
                new Main.Bogie("D", 10),
                new Main.Bogie("E", 10)
        );
        int totalSeats = calculateTotalSeats(bogies);
        assertEquals(50, totalSeats);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Main.Bogie> bogies = new ArrayList<>();
        bogies.add(new Main.Bogie("Sleeper", 72));
        bogies.add(new Main.Bogie("AC Chair", 56));

        int totalSeats = calculateTotalSeats(bogies);

        // Verify total is correct
        assertEquals(128, totalSeats);

        // Verify original list size and contents remain unchanged
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals(72, bogies.get(0).capacity);
    }
}