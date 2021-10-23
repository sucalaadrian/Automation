import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AboutUsPage {
    private final SelenideElement pageTitle = $("div.page-head h3");

    public AboutUsPage() {
        open("http://testfasttrackit.info/magento-test/about-magento-demo-store/");
    }

    // get page title
    public String getPageTitle() {
        return pageTitle.getText();
    }
}
