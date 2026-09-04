package Shared_Data.Browser;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public WebDriver getBrowserFactory()
    {

        String browser = System.getProperty("browser");

        switch(browser){
            case BrowserType.BROWSER_CHROME:
                ChromeServiceBrowser chromeServiceBrowser = new ChromeServiceBrowser();
                chromeServiceBrowser.openBrowser();
                System.out.println("Acum ruleaza pe " + browser);
                return chromeServiceBrowser.getDriver();
            case BrowserType.BROWSER_EDGE:
                EdgeServiceBrowser edgeServiceBrowser = new EdgeServiceBrowser();
                edgeServiceBrowser.openBrowser();
                System.out.println("Acum ruleaza pe " + browser);
                return edgeServiceBrowser.getDriver();
        }
        return null;

    }
}
