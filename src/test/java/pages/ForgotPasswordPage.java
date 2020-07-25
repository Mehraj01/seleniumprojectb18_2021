package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {


    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        //This method accepts two arguments ==> driver instance, and the object reference of the class
        //AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFERENCE OF THE CLASS.
    }

    //input box
    @FindBy(id = "prependedInput")
    public WebElement inputBox;

    //request button
    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

    //error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;


}
