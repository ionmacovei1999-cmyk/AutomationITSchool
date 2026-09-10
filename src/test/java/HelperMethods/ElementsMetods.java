package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementsMetods {

    WebDriver driver;

    public ElementsMetods(WebDriver driver) {
        this.driver = driver;
    }

    private void waitVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element)
    {
        waitVisibility(element);
        element.click();
    }

    public void selectElementFromListByText(List<WebElement> listWebElement, String text)
    {
        for(int i = 0; i< listWebElement.size(); i++)
        {
            if(listWebElement.get(i).getText().equals(text))
            {
                clickOnElement(listWebElement.get(i));
                break;
            }
        }
    }

    public void enterText(WebElement element, String text) {
        waitVisibility(element);
        element.clear();//sterge text din field
        element.sendKeys(text);

    }
}
