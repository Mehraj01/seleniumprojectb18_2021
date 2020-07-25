package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class CybertekCheckboes {
    public static void main(String[] args) throws InterruptedException {

        /*
        Practice: Cybertek Checkboxes

1. Go to http://practice.cybertekschool.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
         */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");


        WebElement checkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        if(!checkBox1.isSelected()){
            System.out.println("Checkbox1 is not selected by default. PASSED");
        }else{
            System.out.println("Checkbox1 is selected by default. FAILED");
        }


        WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(checkBox2.isSelected()){
            System.out.println("Checkbox2 is selected by default. PASSED");
        }else{
            System.out.println("Checkbox2 is not selected by default. FAILED");
        }

        Thread.sleep(1000);
        checkBox1.click();
        Thread.sleep(1000);
        checkBox2.click();


        if(checkBox1.isSelected()){
            System.out.println("Checkbox1 is selected by default. PASSED");
        }else{
            System.out.println("Checkbox1 is not selected by default. FAILED");
        }

        if(!checkBox2.isSelected()){
            System.out.println("Checkbox2 is not selected by default. PASSED");
        }else{
            System.out.println("Checkbox2 is selected by default. FAILED");
        }









    }
}
