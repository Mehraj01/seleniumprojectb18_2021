package test.WarmUp_Tasks.Day8_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T4_IFramePractice {

    /*
    TC #4 : Iframe practice
1. Create a new class called: IframePractice
2. Create new test and make set ups
3. Go to: http://practice.cybertekschool.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
     */


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/iframe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {

        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame("mce_0_ifr");
        WebElement ContentTexts=driver.findElement(By.xpath("//body[.='Your content goes here.']"));
        Assert.assertTrue(ContentTexts.isDisplayed());

        driver.switchTo().parentFrame();
        WebElement iframeHeader=driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iframeHeader.isDisplayed());









    }

}
