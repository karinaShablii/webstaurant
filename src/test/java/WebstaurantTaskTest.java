import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultPage;

import java.util.List;

public class WebstaurantTaskTest extends BaseTest{

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser){
        createWebDriverInstance(browser);
    }


    @Test
    public void assessmentTest(){

        //Open website
        driver.get("https://www.webstaurantstore.com/");

        //Search for "stainless work table"
        MainPage mainPage = new MainPage(driver);
        mainPage.searchByKeyword("stainless steel table");

        //Check the search result ensuring every product has the word "Table" in its title
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> itemDescriptions = searchResultPage.getAllItemsDescriptions();
        for (int i = 1; i <= itemDescriptions.size(); i++) {
            String itemDescription = searchResultPage.getItemDescriptionByElementNumber(i);
            Assert.assertTrue(itemDescription.contains("Table"));
        }

        //Get the number of the last item on the search result page
        int numberOfTheLastItem = searchResultPage.getAllItemsDescriptions().size();

        //Get the description of the last item on the search page for the future verification in the cart
        String descriptionOfTheLastItem = searchResultPage.getItemDescriptionByElementNumber(numberOfTheLastItem);

        //Add last found item to the cart
        searchResultPage.addToCartByItemNumber(numberOfTheLastItem);

        //Go to the cart
        searchResultPage.viewCart();

        //Verify the correct item is displayed in the cart
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemDescription(), descriptionOfTheLastItem);

        //Empty cart and get confirmation message
        String confirmationMessage = cartPage.emptyCart();
        Assert.assertEquals(confirmationMessage, "Your cart is empty.");
    }

    @AfterTest
    public void closeBrowser(){
        tearDown();
    }
}
