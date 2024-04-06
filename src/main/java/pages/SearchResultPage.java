package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePageObject {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //Method collects all item descriptions on the search result page
    public List<WebElement> getAllItemsDescriptions(){
        By itemDescription = By.xpath("//div[@id='ProductBoxContainer']//span[@data-testid='itemDescription']");
        waitForVisibilityOf(itemDescription);
        return driver.findElements(itemDescription);
    }

   //Method returns desired item description
    public String getItemDescriptionByElementNumber(int i){
        return driver.findElement(By.xpath("//div[@id='ProductBoxContainer'][" + i + "]//span[@data-testid='itemDescription']")).getText();
    }

    //Method adds item to the cart by item number
    public void addToCartByItemNumber(int number){
        driver.findElement(By.xpath("//div[@id='ProductBoxContainer'][" + number + "]//div[@class='add-to-cart']")).click();
    }

    //Method clicks on the popup to get to the cart
    public void viewCart(){
        By viewCartButton = By.linkText("View Cart");
        waitForVisibilityOf(viewCartButton);
        driver.findElement(viewCartButton).click();
    }
}
