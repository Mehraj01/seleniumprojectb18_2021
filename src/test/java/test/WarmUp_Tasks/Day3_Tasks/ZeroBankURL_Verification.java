package test.WarmUp_Tasks.Day3_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class ZeroBankURL_Verification {
    public static void main(String[] args) {

        /*
        TC #4: Zero Bank URL verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Get attribute value of href from the “forgot your password” link
4. Verify attribute value contains
Expected: “/forgot-password.html”

         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://zero.webappsecurity.com/login.html");
       WebElement ForgotPasswordLINK=driver.findElement(By.xpath("//a[@href='/forgot-password.html']"));

       // driver.findElement(By.linkText("Forgot your password ?"));

        String actualHrefValue=ForgotPasswordLINK.getAttribute("href");
        String expectedHrefValue="/forgot-password.html";

        if(actualHrefValue.contains(expectedHrefValue)){
            System.out.println("Verification PASSED!");
        }else{
            System.out.println("Verification FAILED!");
        }












    }
}
