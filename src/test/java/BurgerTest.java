import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.*;
import praktikum.Database;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Database database;

    @Before
    public void init() {
        Mockito.when(database.availableBuns()).thenReturn(List.of(new Bun("briosh", 7f)));
        Mockito.when(database.availableIngredients()).thenReturn(List.of(
                new Ingredient(IngredientType.SAUCE, "ranch", 1.5f),
                new Ingredient(IngredientType.FILLING, "chimpken", 2f)
        ));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        float expected = 17.5f;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.0002);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.removeIngredient(1);
        List<Ingredient> actual = burger.ingredients;
        List<Ingredient> expected = List.of(database.availableIngredients().get(0));
        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.moveIngredient(0, 1);
        List<Ingredient> actual = burger.ingredients;
        List<Ingredient> expected = List.of(database.availableIngredients().get(1), database.availableIngredients().get(0));
        assertEquals(expected, actual);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(1));

        String actual = burger.getReceipt();
        StringBuilder receiptBuilder = new StringBuilder("(==== briosh ====)\n");
        receiptBuilder.append("= filling chimpken =\n");
        receiptBuilder.append("(==== briosh ====)\n");
        receiptBuilder.append(String.format("\nPrice: %f\n", 16.0));
        String expected = receiptBuilder.toString();
        assertEquals(expected, actual);
    }
}
