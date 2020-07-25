package test.WarmUp_Tasks.Day2_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerification {
    public static void main(String[] args) throws InterruptedException {


        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        //2. Go to https://www.etsy.com
        // 3. Search for “wooden spoon”
        // 4. Verify title:
              //Expected: “Wooden spoon | Etsy”

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com");
        // this will locate the webElement                           // it will type the wooden spoon to search box + Enter
        //driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon"+ Keys.ENTER); // 1. way

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon"); //2. way
        driver.findElement(By.className("wt-input-btn-group__btn")).click();

        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle=driver.getTitle();


        if(actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification Passed");
        }else{
            System.out.println("Etsy title verification Failed");
        }

        Thread.sleep(3000);



    }
}
