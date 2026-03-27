import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    // Helper methods to simulate the filtering logic
    private List<Main.Bogie> filterUsingLoop(List<Main.Bogie> bogies) {
        List<Main.Bogie> result = new ArrayList<>();
        for (Main.Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    private List<Main.Bogie> filterUsingStream(List<Main.Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("AC Chair", 56)
        );
        List<Main.Bogie> result = filterUsingLoop(bogies);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).type);
    }

    @Test
    void testStreamFilteringLogic() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("AC Chair", 56)
        );
        List<Main.Bogie> result = filterUsingStream(bogies);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).type);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Main.Bogie> bogies = Arrays.asList(
                new Main.Bogie("Sleeper", 72),
                new Main.Bogie("AC Chair", 56),
                new Main.Bogie("First Class", 80),
                new Main.Bogie("General", 90)
        );
        List<Main.Bogie> loopResult = filterUsingLoop(bogies);
        List<Main.Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
        // Verify contents match (assuming order is preserved in both)
        for(int i=0; i < loopResult.size(); i++) {
            assertEquals(loopResult.get(i).type, streamResult.get(i).type);
        }
    }

    @Test
    void testExecutionTimeMeasurement() {
        // This test ensures that the timing mechanism works and produces a positive duration
        long startTime = System.nanoTime();

        // Small workload to measure
        List<Main.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Main.Bogie("Sleeper", 72));
        }
        filterUsingStream(bogies);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        assertTrue(duration > 0, "Execution time should be greater than zero");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Main.Bogie> bogies = new ArrayList<>();
        // Generate a large dataset
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Main.Bogie("Sleeper", 72));
            bogies.add(new Main.Bogie("AC Chair", 56));
        }

        List<Main.Bogie> result = filterUsingLoop(bogies);

        // We added 100k >60 and 100k <60, so the result should be exactly 100k
        assertEquals(100000, result.size());
    }
}