package test.WarmUp_Tasks.Day1_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitleVerification {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED!!!");
        }else{
            System.out.println("Title verification is FAILED!!!");
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
