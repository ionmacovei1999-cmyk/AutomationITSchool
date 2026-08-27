package Tests;

import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WebTableTest {

    @Test
    public void metodaTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );
        WebDriver driver = new ChromeDriver(options);
        //WebDriver driver = new ChromeDriver(); // se acceseaza Chrome
        driver.manage().window().maximize(); // maximizeaza fereastra
        driver.get("https://demoqa.com/"); // acceseaza https://demoqa.com/

        String firstName = "Mihai";
        String lastName = "Macovei";
        String age = "26";
        String email = "test@yahoo.com";
        String salary = "10000";
        String department = "IOT Testing Team";

       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli în jos -  asa se da scrol*/
//      Thread.sleep(millis 2000); - se asteapta 2s nu folosi pt ca oprest threadul si posibil sa strici ceva in spate

//        WebElement elementsButton = driver.findElement(By.xpath("//h5[text()='Elements']")); //gaseste elementul
//        elementsButton.click();
        HomePage homePage = new HomePage(driver);
        homePage.clickElements();

        //*[text()='Web Tables']

        Thread.sleep(2000);


//        WebElement webTableButton = driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        webTableButton.click();

        CommonPage commonPage = new CommonPage(driver);
        commonPage.clickOnSubMenu("Web Tables");

        Thread.sleep(2000);


//        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
//        addButton.click();
//
//        WebElement firstNameField = driver.findElement(By.id("firstName"));
//        firstNameField.sendKeys(firstName);
//
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//        lastNameField.sendKeys(lastName);
//
//        WebElement userEmailField = driver.findElement(By.id("userEmail"));
//        userEmailField.sendKeys(email);
//
//        WebElement ageField = driver.findElement(By.id("age"));
//        ageField.sendKeys(age);
//
//        WebElement salaryField = driver.findElement(By.id("salary"));
//        salaryField.sendKeys(salary);
//
//        WebElement departmentField = driver.findElement(By.id("department"));
//        departmentField.sendKeys(department);
//
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();

        WebTablesPage webTablesPage = new WebTablesPage(driver);
       /* webTablesPage.clickOnAddButton();
        webTablesPage.enterFirstName(firstName);
        webTablesPage.enterLasttName(lastName);
        webTablesPage.enterAge(age);
        webTablesPage.enterUserEmail(email);
        webTablesPage.enterSalary(salary);
        webTablesPage.enterDepartment(department);
        webTablesPage.clickOnSubmitButton();*/

        webTablesPage.addEntry(firstName, lastName, email, age, salary, department);
        webTablesPage.addEntry("Miau", "Dom", "email@gmail.com", "1234", "10000", "department");

        WebElement rowAdded = driver.findElement(By.xpath("(//tr)[5]"));
        String rowAddedText = rowAdded.getText();
        System.out.println(rowAddedText);

//        Assert.assertTrue(rowAddedText.contains("Io"));// assert
//        Assert.assertTrue(rowAddedText.contains("Macovei"));// assert
//        Assert.assertTrue(rowAddedText.contains("26"));// assert
//        Assert.assertTrue(rowAddedText.contains("test@yahoo.com"));// assert
//        Assert.assertTrue(rowAddedText.contains("10000"));// assert
//        Assert.assertTrue(rowAddedText.contains("IOT Testing Team"));// assert

//        WebElement firstNameColumn = driver.findElement(By.xpath("(//tr)[5]//td[1]")); //identificare elemente de la 1 la 6
//        WebElement lastNameColumn = driver.findElement(By.xpath("(//tr)[5]//td[2]"));
//        WebElement ageColumn = driver.findElement(By.xpath("(//tr)[5]//td[3]"));
//        WebElement emailColumn = driver.findElement(By.xpath("(//tr)[5]//td[4]"));
//        WebElement salaryColumn = driver.findElement(By.xpath("(//tr)[5]//td[5]"));
//        WebElement departmentColumn = driver.findElement(By.xpath("(//tr)[5]//td[6]"));
//
//
//        String firstNameColumnText = firstNameColumn.getText();
//        String lastNameColumnText = lastNameColumn.getText();
//        String ageColumnText = ageColumn.getText();
//        String emailColumnText = emailColumn.getText();
//        String salaryColumnText = salaryColumn.getText();
//        String departmentColumnText = departmentColumn.getText();
//
//
//        Assert.assertTrue(firstNameColumnText.equals(firstName));
//        Assert.assertTrue(lastNameColumnText.equals(lastName));
//        Assert.assertTrue(ageColumnText.equals(age));
//        Assert.assertTrue(emailColumnText.equals(email),"E-mailul nu a fost corect");
//        Assert.assertEquals(salaryColumnText,salary);
//
//        Assert.assertTrue(departmentColumn.getText().equals(department));
//        Assert.assertEquals(departmentColumn.getText(), department);

        webTablesPage.verifyEntry(firstName,lastName,email,age,salary,department);








        //h5[text()='Elements'] - Xpath relativ
        // /html/body/div/div/div/div[2]/div/a[1]/div/div/div[3]/h5 //path absolut

    }
}
