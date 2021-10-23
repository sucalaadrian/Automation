import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement pageTitle = $("div.page-title h1");

    public CartPage() {
        Selenide.open("http://testfasttrackit.info/magento-test/checkout/cart/");
    }

    // get page title
    public String getPageTitle() {
        String titleText = pageTitle.getText();
        return titleText;
    }
}
