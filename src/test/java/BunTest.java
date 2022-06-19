import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Супербулочка", 5.5f);

    @Test
    public void nameBunTest() {
        String actual = bun.getName();
        String expected = "Супербулочка";
        assertEquals(expected, actual);
    }

    @Test
    public void giveBunPriceTest() {
        Float actual = bun.getPrice();
        Float expected = 5.5f;
        assertEquals(expected, actual, 000.2);
    }
}
