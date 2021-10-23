import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    private final SelenideElement createAccountButton = $("a.button[href='http://testfasttrackit.info/magento-test/customer/account/create/']");
    private final SelenideElement firstNameInput = $("input#firstname");
    private final SelenideElement lastNameInput = $("input#lastname");
    private final SelenideElement emailAddressInput = $("input#email_address");
    private final SelenideElement passwordInput = $("input#password");
    private final SelenideElement confirmationInput = $("input#confirmation");
    private final SelenideElement registerButton = $("button[title='Register']");
    private final SelenideElement emailValidation = $("div.validation-advice");
    private final SelenideElement firstnameValidation = $("div#advice-required-entry-firstname");
    private final SelenideElement passwordValidation = $("div#advice-validate-cpassword-confirmation");


    public AccountPage() {
        Selenide.open("http://testfasttrackit.info/magento-test/customer/account/login/");
    }

    public void createAnAccount () {
        createAccountButton.click();
    }

    // fill all required fields in the registration form
    public void fillAccountFields(String firstname, String lastname,
                                  String email, String password, String cpassword) {
        firstNameInput.setValue(firstname);
        lastNameInput.setValue(lastname);
        emailAddressInput.setValue(email);
        passwordInput.setValue(password);
        confirmationInput.setValue(cpassword);
        registerButton.click();
    }

    public String getEmailValidationText() {
        return emailValidation.getText();
    }

    public String getFirstnameValidationText() {
        return firstnameValidation.getText();
    }

    public String getPasswordValidationText(){
        return passwordValidation.getText();
    }
}
