package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PracticeForm {

    @Test
    public void maetodaTest() throws InterruptedException {

//        ChromeOptions opt = new ChromeOptions();
//        opt.addExtensions(new File("./Extensions/AdBlock.crx"));

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );// addblocker de la linia 18 la 22
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsButton.click();

        Thread.sleep(2000);

        WebElement practiceFormsButton = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormsButton.click();

        String gender = "Other";

        WebElement maleGenderButton = driver.findElement(By.xpath("//*[@id='gender-radio-1']"));

        WebElement femaleGenderButton = driver.findElement(By.xpath("//*[@id='gender-radio-2']"));

        WebElement otherGenderButton = driver.findElement(By.xpath("//*[@id='gender-radio-3']"));

//        if (gender.equals("Male"))
//        {
//            maleGenderButton.click();
//        }
//        else if (gender.equals("Female"))
//        {
//            femaleGenderButton.click();
//        }
//        else otherGenderButton.click();

        switch (gender)
        {
            case "Male": maleGenderButton.click();
            break;
            case "Female": femaleGenderButton.click();
            break;
            case "Other": otherGenderButton.click();
            break;
        }

        //(//*[@class='form-control'])[3] - pt current Adress
        //*[@class='col-md-9 col-sm-12']//*[@id= 'gender-radio-1'] - alta modalitate pentru gender-radio-1
    }
}
