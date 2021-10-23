import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CategoryPageTest {

    @Test
    public void testPLANTECategoryPage() {
        CategoryPage categoryPage = new CategoryPage();

        String category = "PLANTE";
        categoryPage.goToCategoryPage(category);

        String actualPageTitle = categoryPage.getPageTitle();
        assertEquals(category, actualPageTitle);

        Selenide.sleep(3000);
    }

    @Test
    public void testMENCategoryPage() {
        CategoryPage categoryPage = new CategoryPage();

        String category = "MEN";
        categoryPage.goToCategoryPage(category);

        String actualPageTitle = categoryPage.getPageTitle();
        assertEquals(category, actualPageTitle);

        Selenide.sleep(3000);
    }

    @Test
    public void testSALECategoryPage() {
        CategoryPage categoryPage = new CategoryPage();

        String category = "SALE";
        categoryPage.goToCategoryPage(category);

        String actualPageTitle = categoryPage.getPageTitle();
        assertEquals(category, actualPageTitle);

        Selenide.sleep(3000);
    }
}