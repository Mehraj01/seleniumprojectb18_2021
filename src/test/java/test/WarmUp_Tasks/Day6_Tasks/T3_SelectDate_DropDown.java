package test.WarmUp_Tasks.Day6_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T3_SelectDate_DropDown {

    /*
    TC #3: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select “December 1st, 1921” and verify it is selected.
   Select year using Select month using Select day using
: visible text
: value attribute : index number
     */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void test1(){

        Select selectMonth=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByIndex(11);
        Select selectDay=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByValue("1");
        Select selectYear=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByVisibleText("1921");

        String actualMonth=selectMonth.getFirstSelectedOption().getText();
        String expectedMonth="December";

        String actualDay=selectDay.getFirstSelectedOption().getText();
        String expectedDay="1";

        String actualYear=selectYear.getFirstSelectedOption().getText();
        String expectedYear="1921";

        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);
        Assert.assertTrue(actualYear.equals(expectedYear));





    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
