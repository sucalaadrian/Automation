import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CategoryPage {
    private static final String BASE_URL = "http://testfasttrackit.info/magento-test/";

    private final SelenideElement pageTitle = $("div.page-title");

    public CategoryPage() {
        open(BASE_URL);
    }

    // get page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void goToCategoryPage(String category) {
        open(BASE_URL + category + ".html");
    }
}
