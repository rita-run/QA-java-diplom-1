import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void nameBunTest() {
        Bun bun = new Bun("Супербулочка", 5.5f);
        String actual = bun.getName();
        String expected = "Супербулочка";
        assertEquals(expected, actual);
    }

    @Test
    public void giveBunPriceTest() {
        Bun bun = new Bun("Супербулочка", 5.5f);
        Float actual = bun.getPrice();
        Float expected = 5.5f;
        assertEquals(expected, actual);
    }
}
