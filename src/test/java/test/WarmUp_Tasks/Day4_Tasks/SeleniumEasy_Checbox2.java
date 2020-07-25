package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class SeleniumEasy_Checbox2 {
    public static void main(String[] args) throws InterruptedException {

        /*
        TC #3: SeleniumEasy Checkbox Verification – Section 2
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”
         */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAllButton=driver.findElement(By.xpath("//input[@type='button']"));

        //String actualText = checkAllButton.getAttribute("value");
        String expectedTex="Check All";
        if(checkAllButton.getAttribute("value").equals(expectedTex)){
            System.out.println("Text Verification PASSED!");
        }else{
            System.out.println("Text Verification FAILED");
        }

        checkAllButton.click();

        List<WebElement>listOfCheckedAll=driver.findElements(By.xpath("//input[@class='cb1-element']"));

        for(WebElement each: listOfCheckedAll){
            if(each.isSelected()){
                System.out.println("Verification PASSED!!!" );
            }else{
                System.out.println("Verification FAILED!!!");
            }
        }

        /*
        Thread.sleep(2000);
        checkAllButton.click();// click to uncheck all the boxes

        for(WebElement each: listOfCheckedAll){
            if(!each.isSelected()){
                System.out.println("Verification PASSED!" );
            }else{
                System.out.println("Verification FAILED!" );
            }
        }

         */



        if(checkAllButton.getAttribute("value").equals("Uncheck All")){
            System.out.println("Verify button text changed to “Uncheck All. PASSED!");
        }else{
            System.out.println("Verify button text not changed to “Uncheck All. FAILED!");
        }









    }
}
