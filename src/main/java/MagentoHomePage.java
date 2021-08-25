import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import setup.Setup;

public class MagentoHomePage extends Setup {
    public MagentoHomePage() {
        openHomePage();
    }

    @Step("Open magento page")
    private void openHomePage() {
        Selenide.open("http://testfasttrackit.info/magento-test/");
    }
}
