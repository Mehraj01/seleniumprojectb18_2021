package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Loading1Page {
    public Loading1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
        //This method accepts two arguments ==> driver instance, and the object reference of the class
        //AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFERENCE OF THE CLASS.
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "pwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(id = "flash")
    public WebElement errorMessage;

}
