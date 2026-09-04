package Shared_Data.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeServiceBrowser implements  IBrowserService{


    private WebDriver driver;

    @Override
    public void openBrowser() {
        EdgeOptions options = (EdgeOptions) browserOptions();
        driver = new EdgeDriver(options);
    }

    @Override
    public Object browserOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("start-maximized");
        options.addArguments("no-sandbox");
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
