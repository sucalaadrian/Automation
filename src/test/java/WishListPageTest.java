import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WishListPageTest {

    @Test
    public void testEmptyWishList() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");
        Selenide.sleep(3000);
        WishListPage wishListPage = new WishListPage();
        String expectedText = "You have no items in your wishlist.";
        String actualText = wishListPage.getText();
        assertEquals(expectedText, actualText);
        Selenide.sleep(3000);
    }

    @Test
    public void testNonEmptyWishList() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");

        WishListPage wishListPage = new WishListPage();
        wishListPage.addProductToWishList();

        String expectedText = "rose has been added to your wishlist. Click here to continue shopping.";
        String actualText = wishListPage.getSpanText();
        assertEquals(expectedText, actualText);

        Selenide.sleep(3000);
    }

    @Test
    public void testNonEmptyWishListAfterLogout() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");

        WishListPage wishListPage = new WishListPage();
        wishListPage.addProductToWishList();

        loginPage.doLogout();

        loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");

        wishListPage = new WishListPage();

        String expectedProductName = "ROSE";
        String actualProductName = wishListPage.getProductName();
        assertEquals(expectedProductName, actualProductName);

        Selenide.sleep(3000);
    }

    @Test
    public void testAddToWishListNoUserLogin() {
        WishListPage wishListPage = new WishListPage();
        wishListPage.addProductToWishList();
        Selenide.sleep(3000);
        String expectedPageTitle = "LOGIN OR CREATE AN ACCOUNT";
        String actualPageTitle = wishListPage.getResultPageTitle();
        assertEquals(expectedPageTitle, actualPageTitle);
        Selenide.sleep(3000);
    }

    @Test
    public void testRemoveProductConfirmation() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");

        WishListPage wishListPage = new WishListPage();
        wishListPage.addProductToWishList();
        wishListPage.removeProductFromWishList();

        String expectedText = "Are you sure you want to remove this product from your wishlist?";
        String actualText = Selenide.switchTo().alert().getText();
        assertEquals(expectedText,actualText);

        Selenide.sleep(3000);
    }

    @Test
    public void testRemoveProductFromWishList() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");

        WishListPage wishListPage = new WishListPage();
        wishListPage.addProductToWishList();
        wishListPage.removeProductFromWishList();

        Selenide.switchTo().alert().accept();

        String expectedText = "You have no items in your wishlist.";
        String actualText = wishListPage.getText();
        assertEquals(expectedText, actualText);

        Selenide.sleep(3000);
    }
}