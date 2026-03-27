import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    // Helper methods to simulate the validation logic
    private boolean validateTrainID(String input) {
        if (input == null) return false;
        return Pattern.matches("^TRN-\\d{4}$", input);
    }

    private boolean validateCargoCode(String input) {
        if (input == null) return false;
        return Pattern.matches("^PET-[A-Z]{2}$", input);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(validateTrainID("TRN-1234"));
        assertTrue(validateTrainID("TRN-9999"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrainID("TRAIN12"));
        assertFalse(validateTrainID("TRN12A"));
        assertFalse(validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(validateCargoCode("PET-AB"));
        assertTrue(validateCargoCode("PET-ZZ"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validateTrainID("TRN-123")); // Too short
        assertFalse(validateTrainID("TRN-12345")); // Too long
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validateCargoCode("PET-aB"));
        assertFalse(validateCargoCode("PET-Ab"));
        assertFalse(validateCargoCode("pet-AB")); // Prefix must also be uppercase
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(validateTrainID(""));
        assertFalse(validateCargoCode(""));
        assertFalse(validateTrainID(null));
        assertFalse(validateCargoCode(null));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Ensures the pattern doesn't just match a substring
        assertFalse(validateTrainID(" TRN-1234")); // Leading space
        assertFalse(validateTrainID("TRN-1234 ")); // Trailing space
        assertFalse(validateCargoCode("PET-ABC")); // Extra character
    }
}