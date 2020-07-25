package test.WarmUp_Tasks.Day6_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class T1_2_Select_DropDown {

    /*
    TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
     Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
     Expected: “Select a State”
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){

        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1(){

        Select defaultSelect=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
       String actualDefaultSimpleDropdown=defaultSelect.getFirstSelectedOption().getText();
        String expected="Please select an option";
        Assert.assertEquals(actualDefaultSimpleDropdown,expected);


        Select stateSelection=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualStateSelection=stateSelection.getFirstSelectedOption().getText();
        String expectedStateSelection="Select a State";
        Assert.assertEquals(actualStateSelection,expectedStateSelection);

    }
    @Test
    public void test2() throws InterruptedException {


        Select stateSelection=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        Thread.sleep(1000);
        stateSelection.selectByValue("IL");
        Thread.sleep(1000);
        stateSelection.selectByVisibleText("Virginia");
        Thread.sleep(1000);
        stateSelection.selectByValue("CA");

        String ActualStateCalifornia=stateSelection.getFirstSelectedOption().getText();
        String expectedStateCalifornia="California";

        Assert.assertTrue(ActualStateCalifornia.equals(expectedStateCalifornia));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}




