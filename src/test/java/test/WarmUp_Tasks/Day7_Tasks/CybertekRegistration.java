package test.WarmUp_Tasks.Day7_Tasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/*
TC#6: Cybertek registration form confirmation Note: Use JavaFaker when possible.
1. Open browser
2. Go to website: http://practice.cybertekschool.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.
 */
public class CybertekRegistration {

    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

   @Test
    public void test1(){

        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        WebElement phoneNumber=driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement gender=driver.findElement(By.xpath("//input[@value='female']"));
        WebElement dateOfBirth=driver.findElement(By.xpath("//input[@name='birthday']"));
        Select departmentOffice=new Select(driver.findElement(By.xpath("//select[@name='department']")));

        Select jobTitle=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));

        WebElement checkBox=driver.findElement(By.id("inlineCheckbox2"));

        WebElement signUpButton=driver.findElement(By.xpath("//button[@type='submit']"));


        Faker faker=new Faker();

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        userName.sendKeys("helloWorld");
        email.sendKeys("email@gmail.com");
        password.sendKeys("12345678");
        phoneNumber.sendKeys("578-000-9080");
        gender.click();
        dateOfBirth.sendKeys("12/12/2020");
        departmentOffice.selectByVisibleText("Department of Engineering");
        jobTitle.selectByIndex(1);
        checkBox.click();
        signUpButton.click();

        WebElement successMessage=driver.findElement(By.xpath("//div[@class='alert alert-success']/p"));

        String actualSuccessMessage=successMessage.getText();
        String expectedSuccesMessage="You've successfully completed registration!";
       Assert.assertTrue(actualSuccessMessage.equals(expectedSuccesMessage));







    }


    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        //driver.quit();


    }





}
