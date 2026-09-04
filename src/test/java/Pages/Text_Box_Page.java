package Pages;

import HelperMethods.ElementsMetods;
import ObjectData.TextBoxObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class Text_Box_Page {

    WebDriver driver;
    ElementsMetods elementsMethods;


    public Text_Box_Page(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    WebElement addFullNameColum;

    @FindBy(id = "userEmail")
    WebElement addEmail;

    @FindBy(id = "currentAddress")
    WebElement addCurrentAdress;

    @FindBy(id = "permanentAddress")
    WebElement addPermanentAdress;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//*[@class='border col-md-12 col-sm-12']//*[@id= 'name']")
    WebElement verificareName;

    @FindBy(xpath = "//*[@class='border col-md-12 col-sm-12']//*[@id= 'email']")
    WebElement verificareEmail;

    @FindBy(xpath = "//*[@class='border col-md-12 col-sm-12']//*[@id= 'currentAddress']")
    WebElement verificareCurrentAddress;

    @FindBy(xpath = "//*[@class='border col-md-12 col-sm-12']//*[@id= 'permanentAddress']")
    WebElement verificarePermanentAddress;

    @FindBy(xpath = "//*[@class='border col-md-12 col-sm-12']")
    WebElement rezultatInsert;

//    private String enteredUserName;
//    private String enteredUserEmail;
//    private String enteredCurrentAddress;
//    private String enteredPermanentAddress;


    public void entryTextBox(TextBoxObject textBoxObject) {

//        enteredUserName = userName;
//        enteredUserEmail = userEmail;
//        enteredCurrentAddress = currentAddress;
//        enteredPermanentAddress = permanentAddress;

        addFullNameColum(textBoxObject.getUserName());
        addEmail(textBoxObject.getUserEmail());
        addCurrentAdress(textBoxObject.getCurrentAdress());
        addPermanentAdress(textBoxObject.getPermanentAdress());
        submitButtonClick();
    }


    public void addFullNameColum(String userName) {
        elementsMethods.enterText(addFullNameColum, userName);

    }

    public void addEmail(String userEmail) {
        elementsMethods.enterText(addEmail, userEmail);

    }

    public void addCurrentAdress(String currentAddress) {
        elementsMethods.enterText(addCurrentAdress, currentAddress);

    }

    public void addPermanentAdress(String permanentAddress) {
        elementsMethods.enterText(addPermanentAdress, permanentAddress);

    }

    public void submitButtonClick() {
        elementsMethods.clickOnElement(submitButton);

    }


    public void verificareEntryText(TextBoxObject textBoxObject) {
        Assert.assertEquals(verificareName.getText(), ("Name:" + textBoxObject.getUserName()));
        Assert.assertEquals(verificareEmail.getText(), ("Email:" + textBoxObject.getUserEmail()));
        Assert.assertEquals(verificareCurrentAddress.getText(), ("Current Address :" + textBoxObject.getCurrentAdress()));
        Assert.assertEquals(verificarePermanentAddress.getText(), ("Permananet Address :" + textBoxObject.getPermanentAdress()));
    }

    public void dateinserate() {
        WebElement rowAdded = rezultatInsert;
        String rowaddedText = rowAdded.getText();
        System.out.println(rowaddedText);

    }
}