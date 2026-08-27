package TestsRefactor;

import Pages.CommonPage;
import Pages.HomePage;
import Pages.TextBoxPage;
import Shared_Data.TestBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestBoxTestV2 extends TestBasePage {

    @Test
    public void metodaTest(){

//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments(
//                "--user-data-dir=C:\\SeleniumChromeProfile"
//        );
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/");

        HomePage homepage = new HomePage(getDriver());
        homepage.clickElements();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Text Box");


        String fullName = "Macovei Ion";
        String email = "test@yahoo.com";
        String currentAddress = "Strada Mihai I nr.23";
        String permanentAddress = "Strada Carol II nr.23";


        TextBoxPage textBoxPage = new TextBoxPage(getDriver());
        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.enterCurrentAddress(currentAddress);
        textBoxPage.enterPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();



        textBoxPage.verifySubmit(fullName, email , currentAddress, permanentAddress);


    }
}
