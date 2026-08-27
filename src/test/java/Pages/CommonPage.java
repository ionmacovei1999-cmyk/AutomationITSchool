package Pages;

import HelperMethods.ElementsMetods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementsMetods elementsMetods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    public void clickOnSubMenu(String text)
    {
        elementsMetods.selectElementFromListByText(elements,text);
    }
}
