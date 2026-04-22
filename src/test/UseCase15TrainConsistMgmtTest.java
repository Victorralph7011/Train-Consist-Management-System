import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        Main.GoodsBogie bogie = new Main.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Capture System.out to verify the catch block executed
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.GoodsBogie bogie = new Main.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Error: Unsafe cargo assignment!"));

        System.setOut(System.out); // Restore original stream
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Main.GoodsBogie bogie = new Main.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        // Ensure the unsafe assignment was rejected
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        assertDoesNotThrow(() -> {
            Main.GoodsBogie b1 = new Main.GoodsBogie("Rectangular");
            b1.assignCargo("Petroleum"); // Fails internally, but doesn't crash the app

            Main.GoodsBogie b2 = new Main.GoodsBogie("Open");
            b2.assignCargo("Coal"); // Program continues normally

            assertEquals("Coal", b2.cargo);
        });
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.GoodsBogie bogie = new Main.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum"); // This triggers exception -> catch -> finally

        // Verify the finally block prints its mandatory execution message
        assertTrue(outContent.toString().contains("Cargo validation completed for Rectangular bogie"));

        System.setOut(System.out); // Restore original stream
    }
}