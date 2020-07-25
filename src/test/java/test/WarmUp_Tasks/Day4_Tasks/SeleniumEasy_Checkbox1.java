package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class SeleniumEasy_Checkbox1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.

         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement CheckBox=driver.findElement(By.id("isAgeSelected"));
        WebElement SuccessMessage=driver.findElement(By.xpath("//div[@id='txtAge']"));


      //Verify “Success – Check box is checked” message is NOT displayed.
        if(!CheckBox.isSelected()&& !SuccessMessage.isDisplayed()){
            System.out.println("Verification PASSED!");
        }else{
            System.out.println("Verification FAILED");
        }

        Thread.sleep(1000);
        CheckBox.click();
        if (CheckBox.isSelected()&& SuccessMessage.isDisplayed()){ //or we can only pass SuccessMessage.isDisplayed()
            System.out.println("Success message is displayed. Verification PASSED!");
        }else{
            System.out.println("Success message is not displayed. Verification FAILED!");
        }




    }
}
