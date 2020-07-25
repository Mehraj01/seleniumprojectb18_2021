package test.WarmUp_Tasks.Day2_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {

    public static void main(String[] args) {

        //TC #2: Zero Bank header verification
        //1. Open Chrome browser
        //2. Go to http://zero.webappsecurity.com/login.html
        // 3. Verify header text
               //Expected: “Log in to ZeroBank”


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");


        String actualHeaderText=driver.findElement(By.tagName("h3")).getText();
        String expectedHeaderText="Log in to ZeroBank";


        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Zero Bank header verification Passed");
        }else{
            System.out.println("Zero Bank header verification Failed");
        }


    }
}
