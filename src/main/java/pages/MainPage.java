package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageObject {
    public MainPage(WebDriver driver){
        super(driver);
    }

    public void searchByKeyword(String keyword){

        By searchInput = By.xpath("//div[@data-testid='banner']/div/div[1]//input[@id='searchval']");
        waitForVisibilityOf(searchInput);
        driver.findElement(searchInput).sendKeys(keyword);

        By searchButton = By.xpath("//div[@data-testid='banner']/div/div[1]//button[@value='Search']");
        driver.findElement(searchButton).click();
    }
}
