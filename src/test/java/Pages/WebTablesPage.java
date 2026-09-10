package Pages;

import HelperMethods.ElementsMetods;
import Logger.LoggerUtility;
import ObjectData.WebTableObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebTablesPage {

    WebDriver driver;
    ElementsMetods elementsMetods;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "age")
    WebElement ageField;

    @FindBy(id = "salary")
    WebElement salaryField;

    @FindBy(id = "department")
    WebElement departmentField;

    @FindBy(id = "submit")
    WebElement  submitButton;

    @FindBy(xpath = "(//tr)[5]//td[1]")
    WebElement firstNametColumn;

    @FindBy(xpath = "(//tr)[5]//td[2]")
    WebElement lastNameColumn;

    @FindBy(xpath = "(//tr)[5]//td[3]")
    WebElement ageColumn;

    @FindBy(xpath = "(//tr)[5]//td[4]")
    WebElement emailColumn;

    @FindBy(xpath = "(//tr)[5]//td[5]")
    WebElement salaryColumn;

    @FindBy(xpath = "(//tr)[5]//td[6]")
    WebElement departmentColumn;


    public void addEntry(WebTableObject data)
    {
        clickOnAddButton();
        LoggerUtility.infoTestCase("User clicked on add Button");
        enterFirstName(data.getFirstName());
        LoggerUtility.infoTestCase("User entered First Name");
        enterLasttName(data.getLastName());
        LoggerUtility.infoTestCase("User entered Last Name");
        enterUserEmail(data.getEmail());
        LoggerUtility.infoTestCase("User entered Email");
        enterAge(data.getAge());
        LoggerUtility.infoTestCase("User entered Age");
        enterSalary(data.getSalary());
        LoggerUtility.infoTestCase("User entered Salary");
        enterDepartment(data.getDepartment());
        LoggerUtility.infoTestCase("User entered Department");
        clickOnSubmitButton();
    }

    public void clickOnAddButton()
    {
        elementsMetods.clickOnElement(addButton);
    }

    public void enterFirstName(String firstNameText)
    {
        elementsMetods.enterText(firstNameField,firstNameText);
    }

    public void enterLasttName(String lastNameText)
    {
        elementsMetods.enterText(lastNameField,lastNameText);
    }

    public void enterUserEmail(String emailText)
    {
        elementsMetods.enterText(userEmailField,emailText);
    }

    public void enterAge(String ageText)
    {
        elementsMetods.enterText(ageField,ageText);
    }

    public void enterSalary(String salaryText)
    {
        elementsMetods.enterText(salaryField,salaryText);
    }

    public void enterDepartment(String departmentText)
    {
        elementsMetods.enterText(departmentField,departmentText);
    }

    public void clickOnSubmitButton()
    {
        elementsMetods.clickOnElement(submitButton);
    }

    public void verifyEntry(WebTableObject data)
    {
        Assert.assertTrue(firstNametColumn.getText().equals(data.getFirstName()));
        LoggerUtility.infoTestCase("User verified First Name");
        Assert.assertTrue(lastNameColumn.getText().equals(data.getLastName()));
        LoggerUtility.infoTestCase("User verified Last Name");
        Assert.assertTrue(emailColumn.getText().equals(data.getEmail()),"E-mailul nu a fost corect");
        LoggerUtility.infoTestCase("User verified Email");
        Assert.assertTrue(ageColumn.getText().equals(data.getAge()));
        LoggerUtility.infoTestCase("User verified Age");
        Assert.assertTrue(salaryColumn.getText().equals(data.getSalary()));
        LoggerUtility.infoTestCase("User verified Salary");
        Assert.assertTrue(departmentColumn.getText().equals(data.getDepartment()));
        LoggerUtility.infoTestCase("User verified Department");
    }



}
