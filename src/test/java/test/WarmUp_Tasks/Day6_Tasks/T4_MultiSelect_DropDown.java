package test.WarmUp_Tasks.Day6_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_MultiSelect_DropDown {
    /*
    TC #4: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
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

        Select selectLanguage=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        //selectLanguage.selectByVisibleText("Java");
        //selectLanguage.selectByValue("python");
        List<WebElement>allOptions=selectLanguage.getOptions();
        for(WebElement each: allOptions){
            selectLanguage.selectByVisibleText(each.getText());

        }


        // This list and loop only will print all selected option the console
        List<WebElement>allSelectedOptions=selectLanguage.getAllSelectedOptions();
        for(WebElement each: allSelectedOptions){
            System.out.println(each.getText());
        }




        selectLanguage.deselectAll(); // will deselect all




    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
