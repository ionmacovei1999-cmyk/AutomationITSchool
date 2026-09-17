package Tests.TestsRefactor;

import ObjectData.PracticeFormObject;
import ObjectData.WebTableObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import Shared_Data.TestBasePage;
import XmlReader.XmlDataLoader;
import org.testng.annotations.Test;

import java.util.Map;

public class PracticeFormTest extends TestBasePage {

    private Map<String, PracticeFormObject> PracticeFormObjectMap;

    @Test
    public void metodaTest() throws InterruptedException {

        PracticeFormObjectMap = XmlDataLoader.loadData("C:\\Users\\Lenovo\\Downloads\\project\\AutomationITSchool\\src\\test\\resources\\PracticeFormData.xml", PracticeFormObject.class);
        PracticeFormObject data = PracticeFormObjectMap.get("dataSet_1");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickForms();

        Thread.sleep(2000);

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Practice Form");

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.completeFirstRegionField(data);
        practiceFormPage.completeGender(data);
        practiceFormPage.uploadPicture();
        practiceFormPage.completeStatesAndCity(data);
        practiceFormPage.completeHobbies(data);
        practiceFormPage.completeCalendar(data);
        practiceFormPage.submit();
    }
}
