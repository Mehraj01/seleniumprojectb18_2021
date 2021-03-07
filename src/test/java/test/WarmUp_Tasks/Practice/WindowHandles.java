package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void windowHandle(){

        String currentWindowHandle=driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        WebElement clickLink=driver.findElement(By.linkText("Click Here"));
        System.out.println("BEFORE CLICKING: " + driver.getTitle());
        clickLink.click();
        System.out.println("AFTER CLICKING: " + driver.getTitle());

        Set<String>windowHandles=driver.getWindowHandles();
        for (String each: windowHandles){
            driver.switchTo().window(each);
            System.out.println(driver.getWindowHandle());
            System.out.println(driver.getTitle());
        }

        /*
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getTitle().equals("New Window")){
                Assert.assertTrue(driver.getTitle().equals("New Window"));
                break;
            }
        }

 */
        driver.switchTo().window(currentWindowHandle);
        System.out.println(driver.getTitle());


        /*

             for (String each : windowHandles) {

            driver.switchTo().window(each);
            System.out.println("current title:" + driver.getTitle());

            if (driver.getCurrentUrl().contains("etsy")){
                // 6. Assert: Title contains “Etsy”
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }

        }
         */


    }

}
