import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartPageTest {

    @Test
    public void testEmptyCart() {
        CartPage cartPage = new CartPage();
        String expectedPageTitle = "SHOPPING CART IS EMPTY";
        String actualPageTitle = cartPage.getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle);
        Selenide.sleep(3000);
    }
}