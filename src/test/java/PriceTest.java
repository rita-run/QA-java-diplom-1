import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriceTest {

    private final float checkedPrice;
    private final float expected; // ожидаемый результат

    // конструктор с параметрами
    public PriceTest(float checkedPrice, float expected) {
        this.checkedPrice = checkedPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {0f, 0f},
                {14f, 14f},
                {-5.5f, -5.5f},
        };
    }

    @Test
    public void priceShouldBeCorrect() {
        Bun bun = new Bun("Test", checkedPrice);
        float actual = bun.getPrice();
        assertEquals(expected, actual, 0.0002);
    }

}
