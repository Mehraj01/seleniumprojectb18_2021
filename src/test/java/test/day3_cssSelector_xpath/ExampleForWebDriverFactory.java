package test.day3_cssSelector_xpath;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class ExampleForWebDriverFactory {
    public static void main(String[] args) {

       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
      //  instead of above two line we can below 1 lne code to call it from WebDriverFactory

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }
}
