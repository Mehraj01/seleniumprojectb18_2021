package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrame {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /**
     * Switching to iFrame using:
     *         -> WebElement -> driver.switchTo().frame(iFrame);
     *         -> ID or Name Attribute Value -> Id Attribute value driver.switchTo().frame("mce_0_ifr");
     *         -> Indexes -> driver.switchTo().frame(1);
     *
     *  driver.switchTo().parentFrame();
     *  driver.switchTo().defaultContent();
     */

    @Test
    public void IFrame(){
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        //driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame(1);

        WebElement yourContentGoesHere=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHere.isDisplayed());

        driver.switchTo().parentFrame();
        WebElement h3Text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(h3Text.isDisplayed());

    }

}
