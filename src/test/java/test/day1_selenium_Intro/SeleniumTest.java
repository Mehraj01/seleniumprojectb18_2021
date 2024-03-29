package test.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //1- This line creates the connection between driver and selenium.
        // And sets up the driver.
        WebDriverManager.chromedriver().setup();

        //2- Creating the instance of ChromeDriver to be able to do action on ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //The line below maximizes the browser page after opening it.
        //driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        // TO use firefox driver
        //WebDriver driver = new FirefoxDriver();

        //3- we get google.com
        //String googleUrl = "https://www.google.com";

        driver.get("https://www.google.com");//This methods gets the given URL in an open browser.


        System.out.println("driver.getTitle() --> "+driver.getTitle());
        //- returns the title of the current page as a String
        //- it does not accept any parameter
        //- The title of the page is usually used to confirm what page the user is on
        //- We can compare actual title vs expected title and confirm if we are on the page that we want to be
        System.out.println("driver.getCurrentUrl()--> " + driver.getCurrentUrl());
        //- gets the URL of the current page and returns it as a String
        //- return type is String
        //- it does not accept any parameters
        //- The URL of the page is usually used to confirm what page the user is on
        //- We can compare actual URL vs expected URL and confirm if we are on the page that we want to be


        //BROWSER NAVIGATIONS
        //this line will take user to the previous page
        Thread.sleep(2000); //this line adds 2000milliseconds of wait = 2seconds
        driver.navigate().back();

        //Thread.sleep is being added just to be able to see selenium movements
        Thread.sleep(2000);
        driver.navigate().forward(); //This line will go to next page


        Thread.sleep(2000);
        driver.navigate().refresh(); //This line will refresh the page

        driver.navigate().to("https://www.facebook.com");

        System.out.println("driver.getTitle() --> "+driver.getTitle());
        System.out.println("driver.getCurrentUrl()--> " + driver.getCurrentUrl());

        System.out.println(driver.getPageSource());//this method will return the page source of the current page as a String.

          driver.close();//will close the current browser tab


    }

}
