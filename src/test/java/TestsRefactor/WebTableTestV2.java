package TestsRefactor;

import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablesPage;
import Shared_Data.TestBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WebTableTestV2 extends TestBasePage {

    @Test
    public void metodaTest() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments(
//                "--user-data-dir=C:\\SeleniumChromeProfile"
//        );
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.manage().window().maximize(); // maximizeaza fereastra
//        driver.get("https://demoqa.com/"); // acceseaza https://demoqa.com/

        String firstName = "Mihai";
        String lastName = "Macovei";
        String age = "26";
        String email = "test@yahoo.com";
        String salary = "10000";
        String department = "IOT Testing Team";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        Thread.sleep(2000);


        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Web Tables");

        Thread.sleep(2000);


        WebTablesPage webTablesPage = new WebTablesPage(getDriver());

        webTablesPage.addEntry(firstName, lastName, email, age, salary, department);
        webTablesPage.addEntry("Miau", "Dom", "email@gmail.com", "1234", "10000", "department");

        WebElement rowAdded = getDriver().findElement(By.xpath("(//tr)[5]"));
        String rowAddedText = rowAdded.getText();
        System.out.println(rowAddedText);


        webTablesPage.verifyEntry(firstName,lastName,email,age,salary,department);

    }
}
