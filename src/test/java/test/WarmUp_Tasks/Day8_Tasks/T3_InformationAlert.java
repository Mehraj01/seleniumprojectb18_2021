package test.WarmUp_Tasks.Day8_Tasks;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T3_InformationAlert {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void TC_3() throws InterruptedException {

        WebElement JSPromptButton=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPromptButton.click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("hello");
        Thread.sleep(1000);
        alert.accept();

        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());


    }



}
