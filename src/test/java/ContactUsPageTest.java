import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContactUsPageTest {

    @Test
    public void testPageTitle() {
        ContactUsPage contactUsPage = new ContactUsPage();

        String expectedPageTitle = "CONTACT US";
        String actualPageTitle = contactUsPage.getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle);

        Selenide.sleep(3000);
    }

    @Test
    public void testSendComment() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillRequiredFields("sucala_adrian28@yahoo.com","Adrian1414");

        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.sendComment("This is a test.");

        String expectedMessage = "Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.";
        String actualMessage = contactUsPage.getMessage();
        assertEquals(expectedMessage, actualMessage);

        Selenide.sleep(3000);
    }
}