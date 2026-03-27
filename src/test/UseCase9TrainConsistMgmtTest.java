import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    // Helper method to simulate grouping logic
    private Map<String, List<Main.Bogie>> groupBogies(List<Main.Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("Sleeper", 70)
        );
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("AC Chair", 56),
                new Main.Bogie("AC Chair", 60),
                new Main.Bogie("AC Chair", 50)
        );
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertEquals(3, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("AC Chair", 56)
        );
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Main.Bogie> bogies = new ArrayList<>();
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("First Class", 24),
                new Main.Bogie("First Class", 20)
        );
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("AC Chair", 56),
                new Main.Bogie("First Class", 24)
        );
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertTrue(result.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("Sleeper", 70),
                new Main.Bogie("AC Chair", 56)
        );
        Map<String, List<Main.Bogie>> result = groupBogies(bogies);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Main.Bogie> bogies = new ArrayList<>();
        bogies.add(new Main.Bogie("Sleeper", 72));
        bogies.add(new Main.Bogie("AC Chair", 56));

        Map<String, List<Main.Bogie>> result = groupBogies(bogies);

        // Assert original list size and contents remain unchanged
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("AC Chair", bogies.get(1).name);
    }
}