package Shared_Data.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeServiceBrowser implements IBrowserService{


    private WebDriver driver;

    @Override
    public void openBrowser() {
        ChromeOptions options = (ChromeOptions) browserOptions();
        driver = new ChromeDriver(options);
    }

    @Override
    public Object browserOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\SeleniumChromeProfile");
        options.addArguments("start-maximized");
        options.addArguments("no-sandbox");
        String ciCd = System.getProperty("ci_cd");

        if(Boolean.parseBoolean(ciCd))
        {
            options.addArguments("--headless");
        }
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
