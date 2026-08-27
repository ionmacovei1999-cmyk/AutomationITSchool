package Pages;

import HelperMethods.ElementsMetods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TextBoxPage {


    WebDriver driver;
    ElementsMetods elementsMetods;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    WebElement fullNameField;

    @FindBy(id = "userEmail")
    WebElement emailField;

    @FindBy(id = "currentAddress")
    WebElement currentAdressField;

    @FindBy(id = "permanentAddress")
    WebElement permanentAdressField;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "name")
    WebElement nameCheck;

    @FindBy(id = "email")
    WebElement emailCheck;

    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement currentAddressCheck;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement permanentAddressCheck;


    public void enterFullName(String fullNameText)
    {
        elementsMetods.enterText(fullNameField, fullNameText);
    }

    public void enterEmail(String emailText)
    {
        elementsMetods.enterText(emailField, emailText);
    }

    public void enterCurrentAddress(String currentAddressText)
    {
        elementsMetods.enterText(currentAdressField, currentAddressText);
    }

    public void enterPermanentAddress(String permanentAddressText)
    {
        elementsMetods.enterText(permanentAdressField, permanentAddressText);
    }

    public void clickOnSubmitButton()
    {
        elementsMetods.clickOnElement(submitButton);
    }

    public void verifySubmit(String fullName, String email,String currentAddress, String permanentAddress) {
        Assert.assertTrue(nameCheck.getText().equals("Name:" + fullName), "Numele nu a fost corect");
        Assert.assertTrue(emailCheck.getText().equals("Email:" + email), "E-mailul nu a fost corect");
        Assert.assertTrue(currentAddressCheck.getText().equals("Current Address :" + currentAddress), "Adresa curenta nu a fost cea corecta");
        Assert.assertTrue(permanentAddressCheck.getText().equals("Permananet Address :"+ permanentAddress), "Adresa permanenta nu a fost cea corecta");
    }
}
