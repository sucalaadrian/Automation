import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactUsPage {
    private final SelenideElement pageTitle = $("div.page-title h1");
    private final SelenideElement commentTextArea = $("textarea#comment");
    private final SelenideElement submitButton = $("button[title='Submit']");
    private final SelenideElement successMessageSpan = $("li.success-msg span");

    public ContactUsPage() {
        open("http://testfasttrackit.info/magento-test/contacts/");
    }

    // get page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    // fill the comment
    public void sendComment(String text) {
        commentTextArea.setValue(text);
        submitButton.click();
    }

    public String getMessage() {
        return successMessageSpan.getText();
    }
}
