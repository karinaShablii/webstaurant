package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePageObject {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Get the description of the item added to the cart
    public String getItemDescription(){
        By itemDescription = By.xpath("//span[@class='itemDescription description overflow-visible']");
        waitForVisibilityOf(itemDescription);
        return driver.findElement(itemDescription).getText();
    }

    //Method deletes items from cart and returns the confirmation message
    public String emptyCart(){
        By emptyCartButton = By.xpath("//button[text()='Empty Cart']");
        driver.findElement(emptyCartButton).click();

        By emptyCartConfirmationButton = By.xpath("//footer[@data-testid='modal-footer']//button[1]");
        waitForVisibilityOf(emptyCartConfirmationButton);
        driver.findElement(emptyCartConfirmationButton).click();

        By emptyCartConfirmationMessage = By.xpath("//div[@class='empty-cart__text']/p[1]");
        waitForVisibilityOf(emptyCartConfirmationMessage);
        return driver.findElement(emptyCartConfirmationMessage).getText();
    }
}
