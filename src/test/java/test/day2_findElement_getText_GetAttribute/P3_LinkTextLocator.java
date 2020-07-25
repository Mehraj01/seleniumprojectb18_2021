package test.day2_findElement_getText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkTextLocator {
    public static void main(String[] args) {
/*
TC #3: Back and forth navigation
1-Open a chrome browser
2-Go to: https://google.com
3-Click to Gmail from top right.
4-Verify title contains:Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:Expected: Google
 */

       // 1. Open a chrome Browser and go to google
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        // 2. Click to Gmail link from top right
        driver.get("https://www.google.com");
        driver.findElement(By.linkText("Gmail")).click();

        // 3. Verify Title contains Gmail, expected: "Gmail"
        String actualGmailTitle=driver.getTitle();
        String expectedInTitle="Gmail";
        if(actualGmailTitle.contains(expectedInTitle)){ //Verifying
            System.out.println("Gmail title verification PASSED!");
        }else{
            System.out.println("Gmail title verification FAILED!!!");
        }

        // 4. Go back to Google by using the .back();
        driver.navigate().back();

        // 5. Verify title equals to Google
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";

        if(actualTitle.equals(expectedInTitle)){
            System.out.println("Google page title verification PASSED!");
        }else{
            System.out.println("Google page title verification FAILED!!!");
        }



    }
}
