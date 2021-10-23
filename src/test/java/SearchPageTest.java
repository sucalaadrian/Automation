import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchPageTest {

    @Test
    public void testSearchForNonExistentItem() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchText("empty");
        String expectedMessage = "Your search returns no results.";
        String actualMessage = searchPage.getSearchMessage();
        assertEquals(actualMessage, expectedMessage);
        Selenide.sleep(5000);
    }
}