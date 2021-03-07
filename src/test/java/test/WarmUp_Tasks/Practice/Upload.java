package test.WarmUp_Tasks.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Upload {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.ceallo.com/index.php/apps/files/?dir=/&");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





    }


    @Test
    public void uploadTest(){

        WebElement username=driver.findElement(By.id("user"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement logIn=driver.findElement(By.id("submit-form"));

        username.sendKeys("User1");
        password.sendKeys("Userpass123", Keys.ENTER);



        WebElement addIconDropDown=driver.findElement(By.xpath("//a[@class='button new']"));
        WebElement uploadOption=driver.findElement(By.xpath("//label[@for='file_upload_start']"));

        String pathOfFile="/Users/Sada/Desktop/UploadTest";
        addIconDropDown.click();

        uploadOption.sendKeys(pathOfFile, Keys.ENTER);

    }
}
