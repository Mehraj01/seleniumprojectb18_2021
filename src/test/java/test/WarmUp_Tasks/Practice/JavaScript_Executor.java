package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScript_Executor {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /**
     * 1 - We create javascriptExecutor object and we cast our WebDriver type instance into JavascriptExecutor type.
     * 2 - Then we have access to the methods that are coming from JavascriptExecutor interface.
     *
     * - What is executeScript method?
     *     -> Method coming from JavascriptExecutor, allows us to apply actual javascript code in our selenium code.
     *     -> This method expects 2 arguments.
     *     -> First arg: String. We pass JS code in a string
     *     -> Second arg: We can pass OBJ Type if we want to do specific action on something specific
     */
    @Test
    public void test(){

        WebElement CBSLink=driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", CBSLink);
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);"+ "arguments[0].click()", CBSLink);
       // javascriptExecutor.executeScript("window.scrollBy(0,250);");// scroll down
       // javascriptExecutor.executeScript("window.scrollBy(0,-250)",""); // scroll up
        // javascriptExecutor.executeScript("scrollBy(0,-250)");


        /**
         *  How to handle hidden element
         *  Locate the hidden element in the DOM
         *  Locate element, click on it, verify isDisplayed or not?
         *
         *  If the element exist in the DOM but it does not display on the page in does not give an exceptions.
         *  If the element which does not exist in the DOM. It will throw No Such Element exception.
         *
         */

    }



}

