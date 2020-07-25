package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

//We will store all Login page related web elements and methods into this class.

public class LoginPage {
    //- HOW DID YOU/DO YOU IMPLEMENT IT INTO YOUR FRAMEWORK?
    //	- We implement page object model in 2 steps.
    //	Step #1:
    //		-> We create a public constructor of the class.
    //		-> Then we use PageFactory.initElements();
    //-> This method accepts two arguments.
    //		-> driver instance, and the object reference of the class
    //		-> AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFENCE OF THE CLASS.

    public LoginPage(){
        //PageFactory comes from Selenium
        PageFactory.initElements(Driver.getDriver(), this);// It creates connection in between our driver, and the object of the current class.
        //This method accepts two arguments ==> driver instance, and the object reference of the class
        //AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFERENCE OF THE CLASS.
    }

    //locating username input box
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    //locating input password
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //locating login button
    @FindBy(id = "_submit")
    public WebElement loginButton;

    //locating error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    //locating forgot your password link
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;



    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

}
