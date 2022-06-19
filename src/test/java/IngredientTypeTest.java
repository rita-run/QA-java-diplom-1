import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTypeTest {
    Burger burger = new Burger();
    Bun bun = new Bun("Супербулочка", 5.5f);

    @Test
    public void createBurgerWithFillingTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void createBurgerWithSauceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }
}
