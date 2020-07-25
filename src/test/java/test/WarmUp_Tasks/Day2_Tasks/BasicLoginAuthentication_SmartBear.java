package test.WarmUp_Tasks.Day2_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLoginAuthentication_SmartBear {
    public static void main(String[] args) {

        //TC #5: Basic login authentication 1- Open a chrome browser 2- Go to:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3- Verify title equals:
        //Expected: Web Orders Login
        //4- Enter username: Tester 5- Enter password: test
        //6- Click “Sign In” button 7- Verify title equals:
        //Expected: Web Orders


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expectedTitle="Web Orders Login";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String expTitle="Web Orders";
        //String actTitle=driver.getTitle();

        if(driver.getTitle().equals(expTitle)){
            System.out.println("Landing page title verification PASSED!");
        }else{
            System.out.println("Landing page title verification FAILED!");
        }








    }
}
