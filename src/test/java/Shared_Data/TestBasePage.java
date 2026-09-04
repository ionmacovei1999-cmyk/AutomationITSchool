package Shared_Data;
import Shared_Data.Browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBasePage {
    private WebDriver driver;

    @BeforeMethod
    public void initialiseBrowser() {
//        this.driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver = new BrowserFactory().getBrowserFactory();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void clearBrowser()
    {
        driver.quit();
    }

    public WebDriver getDriver() { // metoda cu return pentru WebDriver(luam driverul)
        return driver;
    }
}
