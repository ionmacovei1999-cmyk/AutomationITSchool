package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class InteractionsSortableTest {

    @Test
    public void metodaTest(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        List<WebElement> cardList = driver.findElements(By.xpath("//*[@class='category-cards']//*[@data-discover='true']")); // lista de webelemente
        cardList.get(4).click();

        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
        elementsList.get(0).click();

        WebElement oneElement = driver.findElement(By.xpath("//div[@data-handler-id= 'T0']"));
        WebElement fiveElement = driver.findElement(By.xpath("//div[@data-handler-id= 'T8']"));

        Actions action = new Actions(driver);
        //action.dragAndDropBy(oneElement,0,-1000).build().perform();//aceasta clasa ruleaza numai cu build si cu perform
        action.clickAndHold(oneElement).moveToElement(fiveElement, 0, 10).release().build().perform();
    }
}
