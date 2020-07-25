package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class FinElements_Apple {
    public static void main(String[] args) {

        /*
        TC #02: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to iPhone
4. Print out the texts of all links
5. Print out how many link is missing text
6. Print out how many link has text
7. Print out how many total link
         */



        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.findElement(By.xpath("//a[@href='/iphone/']")).click();

        List<WebElement>listOfAllLinks=driver.findElements(By.xpath("//body//a"));
        int linkWithText=0;
        int linkWithoutText=0;

        for(WebElement each:listOfAllLinks){
            String textOfLinks=each.getText();
            if(textOfLinks.isEmpty()){
                linkWithoutText++;
            }else{
                System.out.println(textOfLinks);
                linkWithText++;
            }
        }


        System.out.println("Links with Text: "+linkWithText);
        System.out.println("Link without Text: "+linkWithoutText);
        System.out.println("Total link on the page: "+listOfAllLinks.size());


    }
}
