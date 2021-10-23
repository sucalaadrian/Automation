import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    private final SelenideElement searchText = $("input#search");
    private final SelenideElement searchButton = $(".search-button");
    private final SelenideElement searchResult = $(".note-msg");
    private final SelenideElement firstFoundProductImage = $("li.item.last a.product-image");

    public SearchPage() {
        open("http://testfasttrackit.info/magento-test/");
    }

    public void searchText(String text) {
        searchText.setValue(text);
        searchButton.click();
    }

    public void goToFirstFoundProduct() {
        firstFoundProductImage.click();;
    }

    public String getSearchMessage(){
        return searchResult.getText();
    }
}
