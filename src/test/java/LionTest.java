import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    void testDoesHaveManeTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assertions.assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assertions.assertFalse(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeException() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Lion(feline, "Кто-то");
        });
        Assertions.assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного - самей или самка"));
    }

    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
