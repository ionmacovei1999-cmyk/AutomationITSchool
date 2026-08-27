package TestsRefactor;

import Pages.AlertsPage;
import Pages.CommonPage;
import Pages.HomePage;
import Shared_Data.TestBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AlertTestV2 extends TestBasePage {


    @Test
    public void metodaTest(){

//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments(
//                "--user-data-dir=C:\\SeleniumChromeProfile"
//        );
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/");

        HomePage homepage = new HomePage(getDriver());
        homepage.clickAlerts();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Alerts");


        AlertsPage alertPage = new AlertsPage(getDriver());
        alertPage.dealWithAlertOk();
        alertPage.dealWithAlertDelay(5);
        alertPage.alertConfirm();
        alertPage.alertPromt("Bol");

    }
}
