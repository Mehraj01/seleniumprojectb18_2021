package test.WarmUp_Tasks.Day3_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class BasicAuthenticaion_ZeroBank {
    public static void main(String[] args) {

        /*
TC #5: Basic authentication Zero Bank

1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Click sign in button
6. Verify username is displayed on the page
7. Verify the title Zero – Account Summary
8. Verify the link Account Summary’s href value contains: “account-summary”
Print out results in validation formats
         */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement UsernameDisplayed=driver.findElement(By.linkText("username"));

       if(UsernameDisplayed.isDisplayed()){
           System.out.println("Username is displayed on the page. PASSED!");
       }else{
           System.out.println("Username is not displayed on the page. FAILED");
       }


        String expectedTitle="Zero - Account Summary";//Zero - Account Summary

        if(driver.getTitle().equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
      //  WebElement AccountSummaryValue=driver.findElement()

        WebElement AccountSummary=driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=account-summary.html']"));

        String ActualHrefValue=AccountSummary.getAttribute("href");
        String expectedHrefValue="account-summary";

        if(ActualHrefValue.contains(expectedHrefValue)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }






    }
}
