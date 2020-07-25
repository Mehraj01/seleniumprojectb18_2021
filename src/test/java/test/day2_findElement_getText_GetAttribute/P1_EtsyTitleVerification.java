package test.day2_findElement_getText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_EtsyTitleVerification {
    public static void main(String[] args) {

        //TC #1: EtsyTitle Verification
        // 1.Open Chrome browser
        // 2.Go to https://www.etsy.com
        // 3.Search for “wooden spoon”
        // 4.Verify title:
        //      Expected: “Wooden spoon | Etsy”TC
        // #2: Zero Bankheader verification
        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        // 3.Verify header textExpected: “Log in to ZeroBank”




        //TC #1: EtsyTitle Verification
        // 1.Open Chrome browser
        // 2.Go to https://www.etsy.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.etsy.com");


        // 3.Search for “wooden spoon”
       // driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon"+ Keys.ENTER);
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon");
        // locating and clicking to the search button using class attribute value
        driver.findElement(By.className("wt-input-btn-group__btn")).click();

        // 4.Verify title:
        // Expected: “Wooden spoon | Etsy”TC
        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification PASSED!");
        }else{
            System.out.println("Etsy title verification FAILED!!!");
        }


    }
}
