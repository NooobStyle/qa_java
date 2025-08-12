import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTestParams {
    @ParameterizedTest
    @ValueSource(ints = { 10, 0, 3 })
    void testGetKittensCustom(int argument) {
        Feline feline = new Feline();
        assertEquals(argument, feline.getKittens(argument));
    }
}
