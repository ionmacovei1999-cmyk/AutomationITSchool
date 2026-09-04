package Pages;

import HelperMethods.ElementsMetods;
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
        enterFirstName(data.getFirstName());
        enterLasttName(data.getLastName());
        enterUserEmail(data.getEmail());
        enterAge(data.getAge());
        enterSalary(data.getSalary());
        enterDepartment(data.getDepartment());
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
        Assert.assertTrue(lastNameColumn.getText().equals(data.getLastName()));
        Assert.assertTrue(emailColumn.getText().equals(data.getEmail()),"E-mailul nu a fost corect");
        Assert.assertTrue(ageColumn.getText().equals(data.getAge()));
        Assert.assertTrue(salaryColumn.getText().equals(data.getSalary()));
        Assert.assertTrue(departmentColumn.getText().equals(data.getDepartment()));
    }



}
