package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest {


//    String text1 = "Textul din primul iframe este: ";
//    String text2 = "Textul din primul iframe este: ";

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
        cardList.get(2).click();

        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
        elementsList.get(2).click();

        WebElement iframeElement = driver.findElement(By.id("frame1"));//identificare id
        driver.switchTo().frame(iframeElement);  // schimbi focusul driver
        WebElement iframeText = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din primul iframe este: " + iframeText.getText());


        driver.switchTo().defaultContent();//aduce frame-ul initial pt ca in linia anterioara am intrat in frame1

        WebElement iframeElement2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(iframeElement2);
        WebElement iframeText2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din primul iframe este: " + iframeText2.getText());




    }
}
