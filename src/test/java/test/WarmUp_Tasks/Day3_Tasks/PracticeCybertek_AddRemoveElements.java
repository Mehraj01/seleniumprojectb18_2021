package test.WarmUp_Tasks.Day3_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class PracticeCybertek_AddRemoveElements {
    public static void main(String[] args) throws InterruptedException {

        //TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/add_remove_elements/
        // 3. Click to “Add Element” button
        //4. Verify “Delete” button is displayed after clicking.
        //5. Click to “Delete” button.
        //6. Verify “Delete” button is NOT displayed after clicking.

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        Thread.sleep(2000);
        addElementButton.click();
        WebElement DeleteButton=driver.findElement(By.xpath("//button[.='Delete']"));

        if(DeleteButton.isDisplayed()){
            System.out.println("Delete button is displayed. PASSED!");
        }else{
            System.out.println("Delete button is not displayed. FAILED!");
        }

        try{
            DeleteButton.click();
            if(!DeleteButton.isDisplayed()){
                System.out.println("PASSED");
            }else{
                System.out.println("FAILED");
            }
        }catch(StaleElementReferenceException exception){
            System.out.println("StaleElementReferenceException has been thrown ");
            System.out.println("It means element has been completely deleted from the HTML");
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }









    }
}
