import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getNameIngredientTest() {
        String actual = ingredient.getName();
        String expected = "hot sauce";
        assertEquals(actual, expected);
    }

    @Test
    public void getPriceIngredientTest() {
        Float actual = ingredient.getPrice();
        Float expected = 100f;
        assertEquals(actual, expected);
    }

    @Test
    public void getTypeIngredientTest() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(actual, expected);
    }
}
