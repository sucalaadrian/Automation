import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class DemoShopTest {

    MagentoHomePage homePage;

    @BeforeClass
    public void setup() {
        homePage = new MagentoHomePage();
    }

    @Test
    public void I_expect_a_welcome_message() {
        SelenideElement welcomeMessage = $(".welcome-msg");
        welcomeMessage.shouldHave(text("Welcome "));
    }
    @Test
    public void accountButtonHommePage(){
        SelenideElement verrifyMainPageAccount = $(".account-cart-wrapper .skip-account");
        verrifyMainPageAccount.click();
        verrifyMainPageAccount.shouldBe(visible);
        sleep(3000);
    }
}
