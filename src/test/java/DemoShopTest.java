import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class DemoShopTest {

    MagentoHomePage homePage;

    @BeforeClass
    public void setup() {
        homePage = new MagentoHomePage();

    }

    @Test
    public void IExpectAWelcomeMessage() {
        homePage.verifyWelcomeMessage();
    }

    @Test
    public void accountButtonHomePage() {
        homePage.verifyAccountButton();
        homePage.clickOnAccountButton();
        sleep(5000);
    }
}
