package test.day10_jsexecuter_upload_action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class JavaScriptExecuterPractices {

    @Test
    public void jsexecutor_test() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

    //1- We create javascriptExecutor object and we cast our WebDriver type instance into JavascriptExecutor type.
    //2- Then we have access to the methods that are coming from JavascriptExecutor interface.
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
        Thread.sleep(4000);
        // This means scroll down to get the ==> cybertekSchoolLink
        // "arguments[0].scrollIntoView(true);" ==> This JS script will perform scroll down action
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", cybertekSchoolLink);

        //What is executeScript method?
        //	-> Method coming from JavascriptExecutor, allows us to apply actual javascript code in our selenium code.
        //	-> This method expects 2 arguments.
        //	-> First arg: String. We pass JS code in a string
        //	-> Second arg: We can pass OBJ Type if we want to do specific action on something specific




    }

}
