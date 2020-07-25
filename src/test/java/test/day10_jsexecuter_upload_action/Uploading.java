package test.day10_jsexecuter_upload_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

/*
HOW DO YOU HANDLE DOWNLOADS WITH SELENIUM?
-> WE DON'T/CAN'T.
-> Selenium cannot handle downloads except for the clicking the link part.
-> Since selenium can only work with browsers, and the file is downloaded to the computer file directory,
we cannot verify a download using selenium.

HOW DO WE HANDLE UPLOADS WITH SELENIUM?
-> We can upload files using selenium by sending the path of the file into the upload web element.

syntax: uploadWebElement.sendKeys("path of the file");

 */

public class Uploading {

    @Test
    public void uploading_test() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(3000);
        chooseFile.sendKeys("/Users/Sada/Desktop/test");

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.click();

        WebElement uploadedMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(uploadedMessage.isDisplayed());


    }

}
