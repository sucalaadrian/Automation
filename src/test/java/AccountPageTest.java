import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AccountPageTest {

    @Test
    public void testCreateAccount() {
        AccountPage accountPage = new AccountPage();
        accountPage.createAnAccount();
        accountPage.fillAccountFields(
                "Adrian",
                "Test",
                "sucala_adrian28@yahoo.com",
                "Adrian1234",
                "Adrian1234");
        Selenide.sleep(5000);
    }

    @Test
    public void testCreateAccountWithRequiredFieldEmpty() {
        AccountPage accountPage = new AccountPage();
        accountPage.createAnAccount();
        accountPage.fillAccountFields(
                "",
                "Test",
                "sucala_adrian28@yahoo.com",
                "Adrian1234",
                "Adrian1234");
        String expectedValidationText = "This is a required field.";
        String actualValidationText = accountPage.getFirstnameValidationText();
        assertEquals(actualValidationText, expectedValidationText);
        Selenide.sleep(5000);
    }

    @Test
    public void testCreateAccountWithUnmatchedPasswords() {
        AccountPage accountPage = new AccountPage();
        accountPage.createAnAccount();
        accountPage.fillAccountFields(
                "Adrian",
                "Sucala",
                "sucala_adrian28@yahoo.com",
                "Adrian1234",
                "Adrian123");
        String expectedValidationText = "Please make sure your passwords match.";
        String actualValidationText = accountPage.getPasswordValidationText();
        assertEquals(actualValidationText, expectedValidationText);
        Selenide.sleep(5000);
    }

    @Test
    public void testEmailValidation() {
        AccountPage accountPage = new AccountPage();
        accountPage.createAnAccount();
        accountPage.fillAccountFields(
                "Adrian",
                "Test",
                "sucala_adrian28@yahoo",
                "Adrian1234",
                "Adrian1234");
        String expectedValidationText = "Please enter a valid email address. For example johndoe@domain.com.";
        String actualValidationText = accountPage.getEmailValidationText();
        assertEquals(actualValidationText, expectedValidationText);
        Selenide.sleep(5000);
    }

}