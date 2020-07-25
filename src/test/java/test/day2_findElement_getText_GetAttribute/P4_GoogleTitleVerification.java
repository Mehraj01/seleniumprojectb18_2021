package test.day2_findElement_getText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) {
        //TC#4:	Google	search
        // 1-Open	a	chrome	browser
        // for manual importing: Windows: alt+enter, MAC: option+enter
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        // 2-Go	to:	https://google.com
        driver.get("https://www.google.com");
        // 3-Write	“apple”	in	search	box
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);
       // driver.findElement(By.name("q")).sendKeys("apple"); // without Keys.ENTER) it will not press the enter button
        // 4-Click	google	search	button
        //driver.findElement(By.name("btnK")).click();//  ==>This might not work on some comps. Just use Keys.Enter method
                                  // "btnK" its a attribute value of Google Search button name
        // 5-Verify	title:
        String actualTitle=driver.getTitle();
        String expectedInTitle="apple";
        if(actualTitle.startsWith(expectedInTitle)){
            System.out.println("Google search title verification PASSED!");
        }else{
            System.out.println("Google search title verification FAILED!");
        }
        // Expected:	Title	should	start	with	“apple” word









    }
}
