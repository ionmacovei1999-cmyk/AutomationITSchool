package Pages;

import HelperMethods.ElementsMetods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    ElementsMetods elementsMetods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);// fara aceasta linie nu o sa gaseasca elementele
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    WebElement elementsButton;

    @FindBy(xpath = "//h5[text()='Forms']")
    WebElement formsButton;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    WebElement alertsButton;

    public void clickElements()
    {
       elementsMetods.clickOnElement(elementsButton);
    }

    public void clickForms()
    {
        elementsMetods.clickOnElement(formsButton);
    }

    public void clickAlerts()
    {
        elementsMetods.clickOnElement(alertsButton);
    }

}
