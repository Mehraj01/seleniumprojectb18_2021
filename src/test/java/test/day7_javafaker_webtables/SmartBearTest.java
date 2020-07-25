package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // We moved 3 steps to ==> SmartBearUtilities class because of that we have to call it by the classname
        SmartBearUtilities.login(driver);
    }

    @Test
    public void p1_smartbear_login_test(){


        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        //System.out.println("Number of the links: " + allLinks.size());

        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();

        Assert.assertEquals(actualNumberOfLinks, 6);

        //7. Print out each link text on this page

        for (WebElement link : allLinks){
            System.out.println(link.getText());
        }

    }

    @Test
    public void p2_smartbear_order_placing() throws InterruptedException{
        //TC#2: Smartbear software order placing
        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        //driver.findElement(By.xpath(locator)).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), "text to enter");

        //quantityInput.clear(); //just deletes if there is any existing input in the input box.
        Thread.sleep(1000);
        //Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
       // quantityInput.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"2"); // way 1.

        //quantityInput.sendKeys(Keys.BACK_SPACE);

       // Keys.BACK_SPACE ==> Delete the input text first so we can add 2 in there
        quantityInput.sendKeys(Keys.BACK_SPACE+"2");//way 2.
        //quantityInput.sendKeys("2");


       // Thread.sleep(1000);
       // quantityInput.sendKeys("2");
       //quantityInput.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"2");

        //this way works too
        //Thread.sleep(1000);
        ////Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
        //quantityInput.sendKeys(Keys.BACK_SPACE+"2");
        //Thread.sleep(1000);
        //quantityInput.sendKeys(Keys.DELETE+"2");




        //8. Click to “Calculate” button
        WebElement calculateButton=driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
        //9. Fill address Info with JavaFaker
        WebElement inputCustomerName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));



        //• Generate: name, street, city, state, zip code
        Faker faker=new Faker();

        inputCustomerName.sendKeys(faker.name().fullName());

        inputStreet.sendKeys(faker.address().streetName());

        inputCity.sendKeys(faker.address().city());

        inputState.sendKeys(faker.address().state());

        String zipCode=faker.address().zipCode().replaceAll("-", "");// replace all will remove all - signs
        inputZip.sendKeys(zipCode);

        //10. Click on “visa” radio button
        WebElement visaCheckbox=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaCheckbox.click();
        //11. Generate card number using JavaFaker
        WebElement inputCardNumber=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        // Entering credit card number using faker
        //inputCardNumber.sendKeys(faker.finance().creditCard());
        inputCardNumber.sendKeys(faker.finance().creditCard().replaceAll("-", ""));

        // Entering date
        WebElement expirationDate=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("12/25");

        //12. Click on “Process”
        WebElement processButton=driver.findElement(By.xpath("//a[.='Process']"));
        processButton.click();

        //13.Verify success message “New order has been successfully added.”
        // -    //strong
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed());


    }
    @Test
    public void p3_smartBear_order_verification(){

        //2. Click on View all orders
        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susansDate=driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate="01/05/2010";
        String actualDate=susansDate.getText();

        Assert.assertEquals(actualDate, expectedDate);
        //System.out.println(susansDate.getText());


    }




}
