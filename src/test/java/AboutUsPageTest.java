import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AboutUsPageTest {

    @Test
    public void testPageTitle() {
        AboutUsPage aboutUsPage = new AboutUsPage();
        String expectedPageTitle = "OUR STORY";
        String actualPageTitle = aboutUsPage.getPageTitle();
        assertEquals(actualPageTitle, expectedPageTitle);
        Selenide.sleep(5000);
    }
}