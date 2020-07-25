package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class FindElements_Headers_Apple {
    public static void main(String[] args) throws InterruptedException {
/*
TC #03: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out how many links on each page with the titles of the pages
5. Loop through all
6. Print out how many link is missing text TOTAL
7. Print out how many link has text TOTAL
8. Print out how many total link TOTAL
 */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");

        int linkWithoutText = 0;
        int linksWithText = 0;

        Thread.sleep(1000);
        List<WebElement> listOfHeaders=driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));


        for(int i=1; i<8; i++){
            listOfHeaders.get(i).click();
            Thread.sleep(1000);
            List<WebElement>listOfLinks=driver.findElements(By.xpath("//body//a"));
            System.out.println("Number of links on page: " + driver.getTitle() + " " + listOfLinks.size());

            for(WebElement each:listOfLinks){
                String textOfLinks=each.getText();
                if(!textOfLinks.isEmpty()){
                    linksWithText++;
                }else{
                    linkWithoutText++;
                }
            }
            driver.navigate().back();
            listOfHeaders=driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        }
        System.out.println("Links without text: "+linkWithoutText);
        System.out.println("Links with text: "+linksWithText);









    }
}
