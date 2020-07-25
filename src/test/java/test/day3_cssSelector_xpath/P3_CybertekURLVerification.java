package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {
    public static void main(String[] args) {
         // WarmUp Task
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3.Enter any email into input box
        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("anyemail@email.com");
        // 4.Click on Retrieve password
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();//submit()
        // 5.Verify URL contains:
        // Expected: “email_sent”
        String actualURL=driver.getCurrentUrl();
        String expectedURL="email_sent";
        System.out.println("The current URL: "+actualURL);
        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!");
        }
        // 6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”
        // Hint: You need to use getText method for this practice.
        WebElement confirmationMessage=driver.findElement(By.name("confirmation_message"));
        //String actualMessage=driver.findElement(By.name("confirmation_message")).getText();// we cant save the inside web element this time because it gets text

       String actualMessageText= confirmationMessage.getText();
       String expectedMessageText="Your e-mail's been sent!";
       if(actualMessageText.equals(expectedMessageText)){
           System.out.println("Confirmation message text verification PASSED!");
       }else{
           System.out.println("Confirmation message text verification FAILED!");
       }

       if(confirmationMessage.isDisplayed()){
           System.out.println("Message is displayed, verification PASSED!");
       }else{
           System.out.println("Message is NOT displayed, verification FAILED!");
       }






    }
}
