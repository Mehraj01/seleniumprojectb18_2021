package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Alerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /**
     * Alert alert=driver.switchTo().alert();
     * Information Alert: -> alert.accept();
     *
     */
    @Test
    public void informationAlert(){

        WebElement infoAlertButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        infoAlertButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement resultText=driver.findElement(By.xpath("//h4[text()='Result:']"));
        Assert.assertTrue(resultText.isDisplayed());

        String expectedText="You successfuly clicked an alert";
        String actualText=driver.findElement(By.xpath("//p[text()='You successfuly clicked an alert']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }

    /**
     * Alert alert=driver.switchTo().alert();
     * Confirmation Alert: ->  alert.dismiss();  alert.accept();
     */
    @Test
    public void confirmationAlert(){

        WebElement confirmationAlert=driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmationAlert.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        //alert.accept();
        WebElement resultText=driver.findElement(By.xpath("//h4[text()='Result:']"));
        Assert.assertTrue(resultText.isDisplayed());


    }

    /**
     * Locate Alert Button and click on it.
     * Then use Alert class to switch driver focus to Alert.
     * Then accept or dismiss or sendKeys
     *
     * Alert alert=driver.switchTo().alert();
     * Prompt Alert: -> alert.sendKeys("Alert Check");    alert.accept();     alert.dismiss();
     *
     */
    @Test
    public void promptAlert(){

        WebElement promptAlert=driver.findElement(By.xpath("//button[@class='btn btn-primary'][3]"));
        promptAlert.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Alert Check");
        alert.accept();
        //alert.dismiss();

    }





}
