package test.WarmUp_Tasks.Day1_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cybertek_verification {
    public static void main(String[] args) {
        // 1- Set up my webdriver
       WebDriverManager.chromedriver().setup();

        // 2- Create an instance of my chrome driver
       WebDriver driver=new ChromeDriver();

       // 3- Go	to	https://www.google.com
       driver.get("http://practice.cybertekschool.com");

       // 4- verify Url contains cybertekschool
       String url=driver.getCurrentUrl();// Returns The currentURL of the page as a Sting. // Does not accept any arguments
        // Return type: String
      //  System.out.println(url); //url ==> http://practice.cybertekschool.com/


     String expectedUrl="cybertekschool";
      if(url.equals(expectedUrl)){
           System.out.println("PASSED");
     }else{
           System.out.println("FAILED"); // will fail
       }

       // 5- Verify title Practice
       String title=driver.getTitle();// Returns The title of the page as a Sting
                                      // Does not accept any arguments
                                     // Return type: String

        String expectedTitle="Practice";
       if(title.equals(expectedTitle)){
           System.out.println("Passed");
       }else{
           System.out.println("Failed");
       }









    }
}
