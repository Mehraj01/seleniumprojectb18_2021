package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class AddRemoveElements_50Times {
    public static void main(String[] args) throws InterruptedException {

        /*
        TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements 3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking. 5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement AddElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        Thread.sleep(1000);

        for(int i=0; i<5; i++){
            AddElementButton.click();
            Thread.sleep(1000);


        }
/*
        Thread.sleep(1000);
        List<WebElement> DeleteButton50= driver.findElements(By.id("elements"));

        if()

 */
        List<WebElement> ListOfDeleteElements=driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton=driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("Number of Delete button on the page: "+ListOfDeleteElements.size());

        for(WebElement each: ListOfDeleteElements){
            if(each.isDisplayed()){
                System.out.println("Delete Buttons is Displayed. PASSED");
            }else{
                System.out.println("Delete Buttons is not Displayed. FAILED");
            }

        }



        for(WebElement each:ListOfDeleteElements){
            Thread.sleep(1000);
            each.click();
        }
        Thread.sleep(1000);
/*

// This will not work because of StaleElementReferenceException:
  A stale element reference exception is thrown in one of two cases, the first being more common than the second:
                 - The element has been deleted entirely.
                - The element is no longer attached to the DOM.

        for(WebElement each: ListOfDeleteElements){
            if(!each.isDisplayed()){
                System.out.println("Delete button is NOT displayed after clicking. PASS!");
            }else{
                System.out.println("Delete button is displayed after clicking. FAILED!");
            }
        }

 */


        try {
            if (!deleteButton.isDisplayed()){
                System.out.println("Delete button is NOT displayed after clicking. PASS!");
            }else{
                System.out.println("Delete button is displayed after clicking. FAILED!");
            }
        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }






    }
}
