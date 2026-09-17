package Tests.TestsRefactor;

import ObjectData.TextBoxObject;
import ObjectData.WebTableObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablesPage;
import Shared_Data.TestBasePage;
import XmlReader.XmlDataLoader;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

@Listeners(ChainTestListener.class)
public class WebTableTestV2 extends TestBasePage {

    private Map<String, WebTableObject> webTableObjectMap;

    @Test
    public void metodaTest() throws InterruptedException {

        webTableObjectMap = XmlDataLoader.loadData("src/test/resources/WebTableData.xml", WebTableObject.class);
        WebTableObject data = webTableObjectMap.get("dataSet_2");
//        ChromeOptions options = new ChromeOptions();

//        options.addArguments(
//                "--user-data-dir=C:\\SeleniumChromeProfile"
//        );
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.manage().window().maximize(); // maximizeaza fereastra
//        driver.get("https://demoqa.com/"); // acceseaza https://demoqa.com/

//        String firstName = "Mihai";
//        String lastName = "Macovei";
//        String age = "26";
//        String email = "test@yahoo.com";
//        String salary = "10000";
//        String department = "IOT Testing Team";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        ChainTestListener.log("The user clicked on homepage");

        Thread.sleep(2000);


        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Web Tables");

        ChainTestListener.log("The user clicked on submenu");

        Thread.sleep(2000);


        WebTablesPage webTablesPage = new WebTablesPage(getDriver());

        ChainTestListener.log("The user click on Webtable");

//        webTablesPage.addEntry(firstName, lastName, email, age, salary, department);
        webTablesPage.addEntry(data);
        ChainTestListener.log("The user added an full entry");

        WebElement rowAdded = getDriver().findElement(By.xpath("(//tr)[5]"));
        String rowAddedText = rowAdded.getText();
        System.out.println(rowAddedText);


        webTablesPage.verifyEntry(data);
        ChainTestListener.log("All entries are verified");

    }
}
