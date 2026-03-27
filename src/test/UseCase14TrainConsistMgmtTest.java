import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            Main.PassengerBogie bogie = new Main.PassengerBogie("Sleeper", 72);
            assertNotNull(bogie);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(Main.InvalidCapacityException.class, () -> {
            new Main.PassengerBogie("Sleeper", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(Main.InvalidCapacityException.class, () -> {
            new Main.PassengerBogie("AC Chair", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Main.InvalidCapacityException exception = assertThrows(Main.InvalidCapacityException.class, () -> {
            new Main.PassengerBogie("First Class", -5);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Main.InvalidCapacityException {
        Main.PassengerBogie bogie = new Main.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            Main.PassengerBogie b1 = new Main.PassengerBogie("Sleeper", 72);
            Main.PassengerBogie b2 = new Main.PassengerBogie("AC Chair", 56);
            Main.PassengerBogie b3 = new Main.PassengerBogie("First Class", 24);

            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}