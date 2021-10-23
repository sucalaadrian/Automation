import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WishListPage {
    private final SelenideElement wishListText = $("p.wishlist-empty");
    private final SelenideElement addToWishListLink = $("a.link-wishlist");
    private final SelenideElement addedToWishListText= $("li.success-msg span");
    private final SelenideElement removeButton = $("a.btn-remove.btn-remove2");
    private final SelenideElement productName = $("h3.product-name");

    public WishListPage() {
        Selenide.open("http://testfasttrackit.info/magento-test/wishlist/index");
    }

    public String getText() {
        return wishListText.getText();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getSpanText() {
        return addedToWishListText.getText();
    }

    public void addProductToWishList() {
        //Selenide.open("http://testfasttrackit.info/magento-test/plante/rose.html");
        SearchPage searchPage = new SearchPage();
        searchPage.searchText("rose");
        searchPage.goToFirstFoundProduct();
        addToWishListLink.click();
    }

    public String getResultPageTitle() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchText("rose");
        searchPage.goToFirstFoundProduct();
        addToWishListLink.click();
        return $("div.page-title").getText();
    }

    public void removeProductFromWishList() {
        removeButton.click();
    }
}
