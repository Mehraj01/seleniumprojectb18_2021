package test.day2_findElement_getText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTexVSGetAtribute {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");

        // locating gmail link from top right on google page
        System.out.println("get text method: "+driver.findElement(By.linkText("Gmail")).getText());
        System.out.println("get attribute value method: "+driver.findElement(By.linkText("Gmail")).getAttribute("href"));








    }
}
