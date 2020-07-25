package test.WarmUp_Tasks.Day3_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class ForgotPassword_URL_Verification {
    public static void main(String[] args) {

        /*
TC #3: PracticeCybertek/ForgotPassword URL verification

1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”

Hint: You need to use getText method for this practice.
         */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/forgot_password");
        WebElement inputEmail=driver.findElement(By.xpath("//input[@type='text']"));
        inputEmail.sendKeys("email@gmail.com");
        WebElement RetrievePassword=driver.findElement(By.xpath("//i[.='Retrieve password']"));
        RetrievePassword.click();

        String expectedURL="email_sent";
        if(driver.getCurrentUrl().contains(expectedURL)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }

        WebElement expectedtextBoxDisplay=driver.findElement(By.xpath("//h4[@name='confirmation_message']"));

        if(expectedtextBoxDisplay.isDisplayed()){
            System.out.println("TextBox displayed the content as expected. PASSED!");
        }else{
            System.out.println("TextBox did not display the content as expected. FAILED!");
        }




    }
}
