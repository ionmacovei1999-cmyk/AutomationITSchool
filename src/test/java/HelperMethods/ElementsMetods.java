package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
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

    public void enterTextWithEnter(WebElement element, String text) {
        waitVisibility(element);
        element.clear();//sterge text din field
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);

    }

    public void uploadPicture(WebElement element)
    {
        File photo = new File("src/test/resources/poza.jpg");
        element.sendKeys(photo.getAbsolutePath());
    }

    public void enterTextUsingActions(WebElement element, String text)
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(text).perform();
        waitVisibility(element);
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void clickMultipleValues(List<WebElement> webElements, List<String> values)
    {
        for(String value : values)
        {
            for(WebElement webElement : webElements)
            {
                if(webElement.getText().equals(value))
                {
                    String name = webElement.getText();
                    webElement.click();
                }
            }
        }
    }

    public void selectByText(WebElement element,String text)
    {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String text)
    {
        Select dropDown = new Select(element);
        dropDown.selectByValue(text);
    }
}
