import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class LoginPageTest {

    @Test
    public void testCanOpenModal() {
        MagentoHomePage homePage = new MagentoHomePage();
        SelenideElement accountButton = $("a.skip-link.skip-account");
        accountButton.click();
        SelenideElement loginModal = $("div.skip-content.skip-active");
        loginModal.shouldBe(visible);
        sleep(5000);
    }

    @Test
    public void testCanLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields(
                "sucala_adrian28@yahoo.com",
                "Adrian1414"
        );
        Selenide.sleep(5000);
    }

    @Test
    public void testUserIsLoggedOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields(
                "sucala_adrian28@yahoo.com",
                "Adrian1414"
        );
        loginPage.doLogout();
        String expectedPageTitle = "YOU ARE NOW LOGGED OUT";
        String actualPageTitle = loginPage.getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle);
        Selenide.sleep(5000);
    }

    @Test
    public void testEmailValidation() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields(
                "sucala_adrian28@yahoo",
                "Adrian1414"
        );
        String expectedValidationText = "Please enter a valid email address. For example johndoe@domain.com.";
        String actualValidationText = loginPage.getEmailValidationText();
        assertEquals(actualValidationText, expectedValidationText);
        Selenide.sleep(5000);
    }

    @Test
    public void testPasswordValidation() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields(
                "sucala_adrian28@yahoo.com",
                "123"
        );
        String expectedValidationText = "Please enter 6 or more characters without leading or trailing spaces.";
        String actualValidationText = loginPage.getPasswordValidationText();
        assertEquals(actualValidationText, expectedValidationText);
        Selenide.sleep(5000);
    }
}