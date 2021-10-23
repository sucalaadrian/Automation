import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailInput = $("input#email");
    private final SelenideElement passInput = $("input#pass");
    private final SelenideElement loginButton = $("button[title='Login']");

    private final SelenideElement pageTitle = $("div.page-title");

    private final SelenideElement emailValidation = $("div#advice-validate-email-email.validation-advice");
    private final SelenideElement passwordValidation = $("div#advice-validate-password-pass.validation-advice");


    public LoginPage() {
        Selenide.open("http://testfasttrackit.info/magento-test/customer/account/login/");
    }

    // fill all required fields in the login form
    public void fillRequiredFields(String email, String pass) {
        emailInput.setValue(email);
        passInput.setValue(pass);
        loginButton.click();
    }

    public String getEmailValidationText() {
        return emailValidation.getText();
    }

    public String getPasswordValidationText() {
        return passwordValidation.getText();
    }

    // logout user
    public void doLogout() {
        SelenideElement accountButton = $("a.skip-link.skip-account");
        accountButton.click();
        SelenideElement logoutLink = $("a[href='http://testfasttrackit.info/magento-test/customer/account/logout/']");
        logoutLink.click();
    }

    // get page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

}
