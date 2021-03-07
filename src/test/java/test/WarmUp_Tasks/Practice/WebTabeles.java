package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTabeles {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

    }

    @Test
    public void webTable(){

        // tr/td[2]  -> will return all the names. Means All the row (tr) and second cells (td[2])
       List<WebElement >nameList=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
       for (WebElement each: nameList){
           System.out.println("Name: "+each.getText());
       }


       List<WebElement>cardNumbers=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[11]"));
       for (WebElement each: cardNumbers){
           System.out.println("Card Number: "+ each.getText());

       }

       // All Table body -> all the cells and rows infos
      List<WebElement>tBody=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody"));
       for (int i=0; i<tBody.size(); i++){
           System.out.println(tBody.get(i).getText());
       }




    }

}
