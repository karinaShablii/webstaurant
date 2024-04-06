import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
    protected WebDriver driver;

    protected void createWebDriverInstance(String browser){
        System.out.println("creating a " + browser + " WebDriver instance");

        switch(browser){
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                WebDriverManager.safaridriver().arch64().setup();
                driver = new SafariDriver();
                driver.manage().window().maximize();
        }
    }
    protected void tearDown(){
            driver.quit();
    }
}
