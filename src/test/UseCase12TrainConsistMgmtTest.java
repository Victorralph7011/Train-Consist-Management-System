import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    // Helper method to simulate the stream validation logic
    private boolean validateSafety(List<Main.GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(bogie -> bogie.type.equals("Cylindrical") ? bogie.cargo.equals("Petroleum") : true);
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<Main.GoodsBogie> bogies = Arrays.asList(
                new Main.GoodsBogie("Cylindrical", "Petroleum"),
                new Main.GoodsBogie("Open", "Coal")
        );
        assertTrue(validateSafety(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<Main.GoodsBogie> bogies = Arrays.asList(
                new Main.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(validateSafety(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<Main.GoodsBogie> bogies = Arrays.asList(
                new Main.GoodsBogie("Open", "Coal"),
                new Main.GoodsBogie("Box", "Grain"),
                new Main.GoodsBogie("Flatbed", "Steel")
        );
        assertTrue(validateSafety(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<Main.GoodsBogie> bogies = Arrays.asList(
                new Main.GoodsBogie("Cylindrical", "Petroleum"),
                new Main.GoodsBogie("Box", "Grain"),
                new Main.GoodsBogie("Cylindrical", "Water") // Violation
        );
        assertFalse(validateSafety(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<Main.GoodsBogie> bogies = new ArrayList<>();
        // An empty list should inherently pass allMatch because there are no violations
        assertTrue(validateSafety(bogies));
    }
}