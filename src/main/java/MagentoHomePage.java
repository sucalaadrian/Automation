import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import setup.Setup;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MagentoHomePage extends Setup {
     private final SelenideElement welcomeMessage = $(".welcome-msg");
     private final SelenideElement accountButton = $(".account-cart-wrapper .skip-account");
     private final SelenideElement logo = $(".demo-notice");

    public MagentoHomePage() {
        openHomePage();
    }

    @Step("Open magento page")
    private void openHomePage() {
        open("http://testfasttrackit.info/magento-test/");
        verifyLogo();
    }

    /**
     * Verifiers
     */

    public void verifyWelcomeMessage(){
        welcomeMessage.shouldBe(visible);
        welcomeMessage.shouldHave(text("WELCOME"));

    }

    @Step("Check account button")
        public void verifyAccountButton() {
        accountButton.shouldBe(visible);
        accountButton.shouldHave(text("ACCOUNT"));
    }

    @Step("Verify logo")
    public void verifyLogo(){
        logo.shouldBe(visible);
    }

    /**
     *  Actions
     */

    @Step("Click on account button")
    public void clickOnAccountButton(){
        accountButton.click();
    }
}
