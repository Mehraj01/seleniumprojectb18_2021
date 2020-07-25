package test.WarmUp_Tasks.Day3_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class ForgotPassword_WebElementVerification {
    public static void main(String[] args) {

        /*
        TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text

4. Verify all WebElements are displayed.
         */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        WebElement HomeLink=driver.findElement(By.xpath("//a[@class='nav-link']"));
        WebElement ForgotPasswordHeader=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement EmailText=driver.findElement(By.xpath("//label[@for='email']"));
        WebElement EmailInputBox=driver.findElement(By.xpath("//input[@type='text']"));
        WebElement RetrievePasswordButton=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        WebElement PoweredByCybertek=driver.findElement(By.xpath("//div[@style='text-align: center;']"));



        if(HomeLink.isDisplayed()&&ForgotPasswordHeader.isDisplayed()&&EmailText.isDisplayed()
        &&EmailInputBox.isDisplayed()&&RetrievePasswordButton.isDisplayed()&&PoweredByCybertek.isDisplayed()){
            System.out.println("All of the WebElements are displayed. PASSED!");
        }else{
            System.out.println("One or more of the WebElements are not displayed. FAILED!");
        }


    }
}
