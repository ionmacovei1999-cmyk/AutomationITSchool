package Pages;

import HelperMethods.ElementsMetods;
import ObjectData.PracticeFormObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage {


    WebDriver driver;
    ElementsMetods elementsMetods;

    public PracticeFormPage (WebDriver driver) {
        this.driver = driver;
        this.elementsMetods = new ElementsMetods(driver);
        PageFactory.initElements(driver, this);// fara aceasta linie nu o sa gaseasca elementele
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "gender-radio-1")
    WebElement genderRatioMale;

    @FindBy(id = "gender-radio-2")
    WebElement genderRatioFemale;

    @FindBy(id = "gender-radio-3")
    WebElement genderRatioOther;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

   // @FindBy(xpath = "//*[@class = 'subjects-auto-complete__input-container css-19bb58m']")
    @FindBy(id ="subjectsInput")
    WebElement subjectField;

    @FindBy(id = "hobbies-checkbox-1")
    WebElement sportsBox;

    @FindBy(id = "hobbies-checkbox-2")
    WebElement readingBox;

    @FindBy(id = "hobbies-checkbox-3")
    WebElement musicBox;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy(xpath = "(//div[@class= 'css-19bb58m'])[1]")
    WebElement stateField;

    @FindBy(xpath = "(//div[@class= 'css-19bb58m'])[2]")
    WebElement cityField;

    @FindBy(id = "submit")
    WebElement  submitButton;

    public void completeFirstRegionField(PracticeFormObject data){
        elementsMetods.enterText(firstNameField, data.getFirstName());
        elementsMetods.enterText(lastNameField, data.getLastName());
        elementsMetods.enterText(userEmailField, data.getEmailAddress());
        elementsMetods.enterText(currentAddressField, data.getCurrent());
        elementsMetods.enterText(userNumber, data.getPhoneNumber());
        elementsMetods.enterText(subjectField, data.getSubjects());
    }

    public void completeGender(PracticeFormObject data){
        switch (data.getGender())
        {
            case "Male": genderRatioMale.click();
                break;
            case "Female": genderRatioFemale.click();
                break;
            case "Other": genderRatioOther.click();
                break;
        }
    }

}
