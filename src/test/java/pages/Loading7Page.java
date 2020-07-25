package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Loading7Page {


    public Loading7Page(){
        PageFactory.initElements(Driver.getDriver(), this);
        //This method accepts two arguments ==> driver instance, and the object reference of the class
        //AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFERENCE OF THE CLASS.
    }


    @FindBy(xpath = "//strong")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@class='rounded mx-auto d-block']")
    public WebElement spongeBobImage;

}
