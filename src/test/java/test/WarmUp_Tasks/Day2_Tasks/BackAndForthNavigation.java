package test.WarmUp_Tasks.Day2_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {
    public static void main(String[] args) {


        //TC #3: Back and forth navigation
        //1-Open a chrome browser
        //2-Go to: https://google.com
        //3-Click to Gmail from top right.
        //4-Verify title contains:
                 //	Expected: Gmail
        //5-Go back to Google by using the .back();
        //6-Verify title equals:
               //	Expected: Google


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://google.com");
       // System.out.println("Get text method: "+driver.findElement(By.linkText("Gmail")).getText());
       // String gmail= driver.findElement(By.linkText("Gmail")).getAttribute("href");
        driver.findElement(By.linkText("Gmail")).click();
       // System.out.println("Get attribute value method: "+gmail);

        String expectedTitle="Gmail";
        String actualTile=driver.getTitle();

        if(actualTile.contains(expectedTitle)){
            System.out.println("Title contains Gmail: PASSED!");
        }else{
            System.out.println("Title does not contains Gmail: FAILED");
        }

        driver.navigate().back();

        String expectedTitle1="Google";
        String actualTitle1=driver.getTitle();

        if(actualTitle1.equals(expectedTitle1)){
            System.out.println("Title eqaul Google: PASSED");
        }else{
            System.out.println("Title does not equal Google: FAILED");
        }






    }
}
