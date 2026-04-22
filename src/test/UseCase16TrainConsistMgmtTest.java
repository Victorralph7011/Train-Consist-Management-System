import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase16TrainConsistMgmtTest {

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        Main.bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        Main.bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        Main.bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};

        Main.bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};

        Main.bubbleSort(capacities);

        assertArrayEquals(expected, capacities);
    }
}