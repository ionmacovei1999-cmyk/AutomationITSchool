package Pages;

import HelperMethods.ElementsMetods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FramesTestPage {



    WebDriver driver;
    ElementsMetods elementsMetods;

    public FramesTestPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    WebElement iframeElement;

    @FindBy(id = "sampleHeading")
    WebElement iframeText1;

    @FindBy(id = "frame2")
    WebElement iframeElement2;

    @FindBy(id = "sampleHeading")
    WebElement iframeText2;

    public String frame1Text() {
        driver.switchTo().frame(iframeElement);
        String textFrame1 = iframeText1.getText();
        driver.switchTo().defaultContent();
        return  textFrame1;

    }


    public String frame2Text() {
        driver.switchTo().frame(iframeElement2);
        String textFrame2 = iframeText2.getText();
        driver.switchTo().defaultContent();
        return textFrame2;
    }

    public void verifyFrameText(String textFrame1, String textFrame2) {
//        Assert.assertTrue(iframeText1.getText().equals("Textul din primul iframe este: " + textFrame1), "Acesta nu este mesajul corect din frame1");
//        Assert.assertTrue(iframeText2.getText().equals("Textul din al doilea iframe este: " +textFrame2), "Acesta nu este mesajul corect din frame2");
        Assert.assertEquals(textFrame1, "This is a sample page", "Acesta nu este mesajul corect din frame1");
        Assert.assertEquals(textFrame2, "This is a sample page", "Acesta nu este mesajul corect din frame2");
    }

}
