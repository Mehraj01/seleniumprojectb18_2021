package test.WarmUp_Tasks.Day2_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        //TC #4: Google search
        //1- Open a chrome browser
        //2- Go to: https://google.com
        // 3- Write “apple” in search box
        // 4- Click google search button 5- Verify title:
                //Expected: Title should start with “apple” word


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        String expectedTitle="apple";
        String actualTitle=driver.getTitle();

        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Title starts with Apple: PASSED");
        }else{
            System.out.println("Title does not starts with Apple: FAILED");
        }



        Thread.sleep(2000);
       driver.quit();





    }
}
