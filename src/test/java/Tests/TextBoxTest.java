package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class TextBoxTest {

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
        cardList.get(0).click();
        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
        elementsList.get(0).click();

        String fullName = "Macovei Ion";
        String email = "test@yahoo.com";
        String currentAddress = "Strada Mihai I nr.23";
        String permanentAddress = "Strada Carol II nr.23";

        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys(fullName);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys(email);

        WebElement currentAdressField = driver.findElement(By.id("currentAddress"));
        currentAdressField.sendKeys(currentAddress);

        WebElement permanentAdressField = driver.findElement(By.id("permanentAddress"));
        permanentAdressField.sendKeys(permanentAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement name = driver.findElement(By.id("name"));
        assert name.getText().equals("Name:Macovei Ion");

        WebElement emaill = driver.findElement(By.id("email"));
        assert emaill.getText().equals("Email:test@yahoo.com");

        List<WebElement> infoList = driver.findElements(By.xpath("//*[@class='mb-1']"));
        assert infoList.get(2).getText().equals("Current Address :Strada Mihai I nr.23");
        assert infoList.get(3).getText().equals("Permananet Address :Strada Carol II nr.23");

    }
}
