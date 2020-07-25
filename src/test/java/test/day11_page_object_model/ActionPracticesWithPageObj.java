package test.day11_page_object_model;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.Driver;

/*
ACTIONS:
-> WHY DO WE NEED ACTIONS CLASS? WHAT DOES IT DO?
-> Actions class allows us to handle complex/advanced mouse and keyboard actions. Such as:
-> hover over : moveToElement
-> right click: contextClick
-> dragAndDrop: allows us to drag and drop a web element
-> clickAndHold: clicks onto something and waits for next command
-> release :
How do we use Actions methods?
1- To be able to use any Actions method, we need to create the instance of the actions class.
2- Then we need to pass the current driver instance into the constructor.
3- We must use : perform() method at the end to be able to perform any actions method.

 */

public class ActionPracticesWithPageObj {
//moveToElement ==> hover over
//contextClick ==> right click
//dragAndDrop ==> to drag and drop a web element
//clickAndHold ==> clicks onto something and waits for next command
//release ==> releasing hold element
//perform() ==> method at the end to be able to perform any actions method.


    @Test
    public void tc15_hover_over_test() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        HoversPage hoversPage = new HoversPage();
        Actions actions = new Actions(Driver.getDriver());


        //2. Hover over to first image

        //3. Assert:
        //a. “name: user1” is displayed
        Thread.sleep(3000);

        actions.moveToElement(hoversPage.img1).perform();

        Assert.assertTrue(hoversPage.user1.isDisplayed());

        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        Thread.sleep(3000);

        actions.moveToElement(hoversPage.img2).perform();

        Assert.assertTrue(hoversPage.user2.isDisplayed());


        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        Thread.sleep(3000);
        actions.moveToElement(hoversPage.img3).perform();

        Assert.assertTrue(hoversPage.user3.isDisplayed());




    }
}
