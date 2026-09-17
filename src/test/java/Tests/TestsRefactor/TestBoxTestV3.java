package Tests.TestsRefactor;

import ObjectData.TextBoxObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.TextBoxPage;
import Pages.Text_Box_Page;
import Shared_Data.TestBasePage;
import XmlReader.XmlDataLoader;
import org.testng.annotations.Test;

import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class TestBoxTestV3 extends TestBasePage {
    private Map<String, TextBoxObject> textBoxObjectMap;

    @Test
    public void metodaTest() throws InterruptedException {

        textBoxObjectMap = XmlDataLoader.loadData("src/test/resources/TextBoxData.xml", TextBoxObject.class);
        TextBoxObject data = textBoxObjectMap.get("dataSet_1");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsWithJavaScripts();

        Thread.sleep(2000);

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Text Box");

        Thread.sleep(2000);

        Text_Box_Page textBoxPage = new Text_Box_Page(getDriver());
        textBoxPage.entryTextBox(data);

        textBoxPage.dateinserate();

        textBoxPage.verificareEntryText(data);

    }
}
