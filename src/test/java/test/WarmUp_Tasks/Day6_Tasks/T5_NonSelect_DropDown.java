package test.WarmUp_Tasks.Day6_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T5_NonSelect_DropDown {
    /*
    TC #5: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
     */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {

        WebElement dropDownLink=driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        WebElement FacebookLink=driver.findElement(By.xpath("//a[.='Facebook']"));
        dropDownLink.click();
        Thread.sleep(1000);
        FacebookLink.click();
        //driver.navigate().back();

        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);

    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
