package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMetods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    WebDriver driver;
    ElementsMetods elementsMetods;
    AlertMethods alertMethods;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public void dealWithAlertOk()
    {
        elementsMetods.clickOnElement(alertButton);
        alertMethods.alertOk();
    }

    public void dealWithAlertDelay(int seconds)
    {
        elementsMetods.clickOnElement(timerAlertButton);
        alertMethods.alertWithDelay(seconds);
    }

    public void alertConfirm()
    {
        elementsMetods.clickOnElement(confirmButton);
        alertMethods.alertConfirm();
    }

    public void alertCancel()
    {
        elementsMetods.clickOnElement(confirmButton);
        alertMethods.alertCancel();
    }

    public void alertPromt(String value)
    {
        elementsMetods.clickOnElement(promtButton);
        alertMethods.alertText(value);
    }

}
