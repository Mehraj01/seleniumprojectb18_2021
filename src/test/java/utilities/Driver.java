package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//We create Driver utilities using Singleton Design Pattern.
//-> How did we achieve singleton?
//-> We created private constructor, and created a method to return the instance of that class. (WebDriver)

//- A design pattern is not a framework. It is just the part of a framework.
//- Usually just another layer in our framework to make "something" easy to handle for ourselves.

public class Driver {// Singleton Class: private constructor and public getter method

    private Driver(){//1-Make constructor private
// Private constructor : ensures that none else can create an instance of the WebDriver
//	  -We will allow reach to this driver only through our getter method.
    }

    private static WebDriver driver;// private static variable

    public static WebDriver getDriver(){// getter method will allow read only

        if (driver == null){// if my driver is null. It will not create a drive if already were created
            String browser = ConfigurationReader.getProperty("browser"); // ConfigurationReader is the class name
                                               //and getProperty() is the getter method we created inside the class
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

            }
        }

        return driver;

    }

    public static void closeDriver(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }

    /*
    DRIVER UTILITY
Some challenges:
- We have too many lines to just to initialize the driver
- Being able to pass the same driver instance when calling methods from other classes
get amazon page - Webdriver driver1.get
find search bar Webdriver driver2.search
send keys Webdriver driver3.sendKey
SOLUTION: Creating a driver utility that guarantees a single instance of the driver and does the initial setup as well. (maximize, impilictwait etc)
Singleton Design pattern:
	What happens if you create private constructor?
	-> You cannot create an object of that class.
What singleton is?
	-> We create a private constructor, and we also create a getter method to allow users to create the instance of this class in OUR WAY.
REASONS:
	idea of driver: we want to get the same driver instance whenever we want
We achieve this with Driver utility
Driver utility:
1- Private constructor : ensures that none else can create an instance of the WebDriver
	-We will allow reach to this driver only through our getter method.
2- We create a logic to ensure that the same driver instance is passed every single time:
	if(driver==null){
		//this statement will ensure that the new instance will be created only if the driver object is empty
		String browser = ConfigurationReader.getProperty("browser");
		//this line will read what browser we want to run on dynamically from configuration.properties
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
	}
     */




}
