package test.WarmUp_Tasks.Day4_Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {

        /*
        TC #0: FINDELEMENTS

1. Open Chrome browser
2. Go to https://www.merriam-webster.com/
3. Print out the texts of all links
4. Print out how many link is missing text
5. Print out how many link has text
6. Print out how many total link
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com ");
        //driver.findElements(By.l)
        List<WebElement> ListOfLinks=driver.findElements(By.xpath("//body//a"));


       int linkWithText=0;
       int linkWithoutText=0;

        for(int i=0; i<ListOfLinks.size();i++ ){
            String TextOfLinks=ListOfLinks.get(i).getText();

            if(TextOfLinks.isEmpty()){
                linkWithoutText++;
            }else{
                System.out.println(TextOfLinks);
                linkWithText++;
            }

        }

/*

        for(WebElement each:ListOfLinks){
            String textOfLinks=each.getText();
            if(textOfLinks.isEmpty()){
                linkWithoutText++;
            }else{
                System.out.println(textOfLinks);
                linkWithText++;
            }
        }

 */

        System.out.println("Link with Text: "+linkWithText);
        System.out.println("Link without Text: "+linkWithoutText);
        System.out.println("Total link of the page: "+ListOfLinks.size());



    }
}
