package test.WarmUp_Tasks.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Action_1 {

    /**
     *
     * - actions.dragAndDrop(draggable,droptarget).perform(); -> drag and drop
     * - actions.moveToElement(img1).perform(); -> Hovers overs
     * - actions.doubleClick(textDoubleClick).perform(); -> double click on the element
     * - actions.clickAndHold(draggable).moveToElement(dropTarget).perform(); -> click and hold
     * - actions.release().perform(); -> releasing hold element
     * - actions.contextClick(box).perform(); -> right click
     */


    @Test
    public void DragDrop() {

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Actions actions=new Actions(Driver.getDriver());// Pass the current driver instance

        WebElement draggable=Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement droptarget=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));



        actions.dragAndDrop(draggable,droptarget).perform();
        Assert.assertEquals(droptarget.getText(), "You did great!");



    }


    @Test
    public void HoverOver(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // - (//img[@alt='User Avatar'])[1] ->  we use () parenthesis means get the first particular element.
        //                                      It dose not matter if they are children or not
        WebElement img1=driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        // - //*[text()='name: user1'] -> * means All text
        WebElement img1Text= driver.findElement(By.xpath("//*[text()='name: user1']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(img1Text.isDisplayed());

        // this will hover all the images
        List<WebElement>images=driver.findElements(By.tagName("img"));
        for (WebElement each:images) {
            actions.moveToElement(each).pause(2000).perform();
        }

    }


    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement CBTLink=driver.findElement(By.linkText("Cybertek School"));
        WebElement inputLink=driver.findElement(By.linkText("Inputs"));

        Actions actions=new Actions(driver);
        actions.moveToElement(CBTLink).perform();

        actions.moveToElement(inputLink).click().perform();


    }


    @Test
    public void DoubleClick(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.switchTo().frame("iframeResult");

        WebElement textDoubleClick=driver.findElement(By.id("demo"));
        Actions actions=new Actions(driver);
        actions.doubleClick(textDoubleClick).perform();

        String actual=textDoubleClick.getAttribute("style");
        String expected="color: red;";
        Assert.assertTrue(actual.equals(expected));

        driver.switchTo().parentFrame();


    }

    @Test
    public void clickAndHold(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement dropTarget= driver.findElement(By.id("droptarget"));

        Actions actions=new Actions(driver);
        //actions.clickAndHold(draggable).moveToElement(dropTarget).release().perform();
        //actions.release().perform();


        actions.clickAndHold(draggable).moveToElement(dropTarget).release().build().perform();
    }

    @Test
    public void RightClick(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform(); // Alert will open

        Alert alert=driver.switchTo().alert();
        alert.accept();

    }


}
