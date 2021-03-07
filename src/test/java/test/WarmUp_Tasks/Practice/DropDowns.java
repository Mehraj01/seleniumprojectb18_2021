package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDowns {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

     /*
        1- Select DropDowns: are created by using <select> tag in HTML
	<select>
		<option value="1"> ORANGE </option>
		<option value="2"> APPLE </option>
		<option value="3"> KIWI </option>
	</select>


	Select ByText -> selectByVisibleText("Option 1");
	Select ByValue -> selectByValue("FL");
	Select ByIndex -> selectByIndex(44);

	Multi Select DropDown
	 - getOptions();
     - getAllSelectedOptions();


         */

// =====================================================================================================================
    /**
     * Select ByText -> selectByVisibleText("Option 1");
     */
    @Test
    public void selectByText(){

        Select simpleDropDown=new Select(driver.findElement(By.id("dropdown")));
        simpleDropDown.selectByVisibleText("Option 1");
        simpleDropDown.selectByVisibleText("Option 2");

    }
    /**
     * Select ByValue -> selectByValue("FL");
     */
    @Test
    public void selectByValue(){
        Select stateSelection=new Select(driver.findElement(By.id("state")));
        stateSelection.selectByValue("FL");

        String expectedValue="Florida";
        String actualValue=stateSelection.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedValue,actualValue);
    }

    /**
     * Select ByIndex -> selectByIndex(44);
     */
    @Test
    public void selectByIndex(){
        Select stateSelection=new Select(driver.findElement(By.id("state")));
        stateSelection.selectByIndex(44);

        String expected="Texas";
        String actual =stateSelection.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }

// =====================================================================================================================
    /**
     * Multi Select Dropdown
     * getOptions();
     * getAllSelectedOptions();
     */
    @Test
    public void multiSelectDropDown(){

        Select languageSelection=new Select(driver.findElement(By.name("Languages")));

        List<WebElement>options=languageSelection.getOptions();
        for (int i=0; i<options.size(); i++){

           languageSelection.selectByVisibleText(options.get(i).getText());
        }



        // Will print all the selected options to the console
        List<WebElement>selectOption=languageSelection.getAllSelectedOptions();
        for (int i=0; i<selectOption.size(); i++){
            System.out.println(selectOption.get(i).getText());
        }

        languageSelection.deselectAll();
    }


// =====================================================================================================================
    /**
     * Non Select dropDown
     */
    @Test
    public void nonSelectDropDown(){

        WebElement dropDown=driver.findElement(By.id("dropdownMenuLink"));
        WebElement option=dropDown.findElement(By.xpath("//a[text()='Google']"));
        dropDown.click();
        option.click();
    }


// =====================================================================================================================
    /**
     * year, month, day
     */
    @Test
    public void test(){

        Select year=new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1986");

        Select month=new Select(driver.findElement(By.id("month")));
        month.selectByIndex(1);

        Select day=new Select(driver.findElement(By.id("day")));
        day.selectByValue("3");

    }
}
