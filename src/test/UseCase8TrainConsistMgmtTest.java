import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase8TrainConsistMgmtTest {

    // Helper method to simulate the stream logic from Main.java
    private List<Main.Bogie> filterBogies(List<Main.Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Main.Bogie> bogies = Arrays.asList(new Main.Bogie("Test", 75));
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Main.Bogie> bogies = Arrays.asList(new Main.Bogie("Test", 70));
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Main.Bogie> bogies = Arrays.asList(new Main.Bogie("Test", 65));
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(0, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("A", 80),
                new Main.Bogie("B", 50),
                new Main.Bogie("C", 90)
        );
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("A", 50),
                new Main.Bogie("B", 60)
        );
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(0, result.size());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("A", 80),
                new Main.Bogie("B", 90)
        );
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Main.Bogie> bogies = new ArrayList<>();
        List<Main.Bogie> result = filterBogies(bogies, 70);
        assertEquals(0, result.size());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Main.Bogie> bogies = new ArrayList<>();
        bogies.add(new Main.Bogie("A", 80));
        bogies.add(new Main.Bogie("B", 50));

        List<Main.Bogie> result = filterBogies(bogies, 70);

        // Assert original list size remains 2, while filtered list has 1
        assertEquals(2, bogies.size());
        assertEquals(1, result.size());
    }
}