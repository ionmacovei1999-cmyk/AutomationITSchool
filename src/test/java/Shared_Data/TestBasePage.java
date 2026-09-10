package Shared_Data;
import Logger.LoggerUtility;
import Shared_Data.Browser.BrowserFactory;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public class TestBasePage {
    private WebDriver driver;
    public String testName;

    @BeforeMethod
    public void initialiseBrowser() {
//        this.driver = new ChromeDriver();
//        driver.manage().window().maximize();
        ThreadContext.put("testName", this.getClass().getSimpleName());//gaseste numele testului si denumeste numele threadului ca nume al testului
        testName = this.getClass().getSimpleName();
        driver = new BrowserFactory().getBrowserFactory();
        LoggerUtility.infoTestCase("===== The browser started successfully");
        LoggerUtility.startTestCase(testName);
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void clearBrowser(ITestResult result)
    {
        driver.quit();
        LoggerUtility.infoTestCase("The browser was closed successfully");
        if(result.getStatus() == ITestResult.FAILURE)
        {
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        LoggerUtility.infoTestCase("===== The browser closed successfully");
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public void finishLogFiles(){
        LoggerUtility.mergeFiles();
    }

    public WebDriver getDriver() { // metoda cu return pentru WebDriver(luam driverul)
        return driver;
    }
}
