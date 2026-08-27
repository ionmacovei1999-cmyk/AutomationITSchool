package Tests;

import Pages.AlertsPage;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertTest {

    @Test
    public void metodaTest(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        HomePage homepage = new HomePage(driver);
        homepage.clickAlerts();

        CommonPage commonPage = new CommonPage(driver);
        commonPage.clickOnSubMenu("Alerts");

//        List<WebElement> cardList = driver.findElements(By.xpath("//*[@class='category-cards']//*[@data-discover='true']")); // lista de webelemente
//        cardList.get(2).click();
//        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
//        elementsList.get(1).click();
//
//        WebElement alertButton = driver.findElement(By.id("alertButton"));
//        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
//        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
//        WebElement promtButton = driver.findElement(By.id("promtButton"));

//        alertButton.click();
//        Alert alertok = driver.switchTo().alert();
//        alertok.accept();

        AlertsPage alertPage = new AlertsPage(driver);
        alertPage.dealWithAlertOk();
        alertPage.dealWithAlertDelay(5);
        alertPage.alertConfirm();
        alertPage.alertPromt("Bol");

//        timerAlertButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alertFiveSeconds = driver.switchTo().alert();
//        alertFiveSeconds.accept();
//
//        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
//        confirmButton.click();
//        Alert alertConfirm = driver.switchTo().alert();
//        alertConfirm.dismiss();
//
//        promtButton.click();
//        Alert promtAlert = driver.switchTo().alert();
//        promtAlert.sendKeys("Ion");
//        promtAlert.accept();

    }
}
