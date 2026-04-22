import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_EmptyTrainThrowsException() {
        String[] emptyConsist = {};

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            Main.binarySearch(emptyConsist, "BG101");
        });

        assertEquals("Cannot perform search: Train consist is empty.", exception.getMessage());
    }

    @Test
    void testSearch_NullTrainThrowsException() {
        String[] nullConsist = null;

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            Main.binarySearch(nullConsist, "BG101");
        });

        assertEquals("Cannot perform search: Train consist is empty.", exception.getMessage());
    }

    @Test
    void testSearch_ValidTrainDoesNotThrow() {
        String[] validConsist = {"BG101", "BG205"};

        assertDoesNotThrow(() -> {
            Main.binarySearch(validConsist, "BG101");
        });
    }

    @Test
    void testLinearSearch_EmptyTrainThrowsException() {
        String[] emptyConsist = {};

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            Main.linearSearch(emptyConsist, "BG101");
        });

        assertEquals("Cannot perform search: Train consist is empty.", exception.getMessage());
    }
}