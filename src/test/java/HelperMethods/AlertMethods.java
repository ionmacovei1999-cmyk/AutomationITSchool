package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    WebDriver driver;
    WebDriverWait wait;

    public AlertMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void alertOk()
    {
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

    public void alertWithDelay(int seconds)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
        alertOk();
    }

    public void alertConfirm()
    {
        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.accept();
    }

    public void alertCancel()
    {
        Alert alertCancel = driver.switchTo().alert();
        alertCancel.dismiss();
    }

    public void alertText(String value)
    {
        Alert alertText = driver.switchTo().alert();
        alertText.sendKeys(value);
        alertText.accept();
    }
}