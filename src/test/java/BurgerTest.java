import org.junit.Test;
import org.mockito.Mock;
import praktikum.*;
import praktikum.Database;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database db = new Database();
    Burger burger = new Burger();

    @Mock
    Burger mock_burger;

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Супербулочка", 5.5f);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = bun.getPrice() * 2 + ingredient.getPrice();
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.0002);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        Boolean actual = burger.ingredients.isEmpty();
        assertEquals(true, actual);
    }

    @Test
    public void moveIngredientTest() {
        mock_burger.moveIngredient(0, 1);
        Mockito.verify(mock_burger).moveIngredient(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void getReceiptMockTest() {
        System.out.println(mock_burger.getReceipt());
        Mockito.when(mock_burger.getReceipt()).thenReturn("Чек выдан");
        System.out.println(mock_burger.getReceipt());
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(db.availableBuns().get(0));
        burger.addIngredient(db.availableIngredients().get(0));
        String actual = burger.getReceipt();
        StringBuilder receiptBuilder = new StringBuilder("(==== black bun ====)\n");
        receiptBuilder.append("= sauce hot sauce =\n");
        receiptBuilder.append("(==== black bun ====)\n");
        receiptBuilder.append(String.format("\nPrice: %f\n", 300.0));
        String expected = receiptBuilder.toString();
        assertEquals(expected, actual);
    }
}
