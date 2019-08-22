package pawaskar.prachi.PageFactoryTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // List all the elements to be used from the page
    WebDriver driver;

    //Initialize elements different then POM, here is done using @FindBy instead of "By" object
    // POM example is "By usernameElement = By.id("user_login");"
    @FindBy(id = "user_login")
    WebElement usernameElement;

    @FindBy(id = "user_password")
    WebElement passwordElement;

    @FindBy(xpath = "//*[@value=\"Sign in\"]")
    WebElement loginButtonElement;

    // Constructor to initialize the driver
    public  LoginPage(WebDriver driver){
        //Links the driver from test class and the driver from this class
        this.driver = driver;
        // Otherwise Web elments do not get initialize and hence no value of xpath/id etc is assigned to web element
        // Results in NPE on web element usage is not used
        PageFactory.initElements(driver, this);
    }


    //Enter user name in text box
    //Internal method
    public void enterUsername(String username){
        //enter user name
        //Use webelement directly instead driver.By syntax as in POM
        usernameElement.sendKeys(username);
    }

    //Enter password in text box
    //Internal method
    public void enterPassword(String password){
        //enter password
        passwordElement.sendKeys(password);
    }

    //Click login
    //Internal method
    public void clickLogin(){
        loginButtonElement.click();
    }

    //Method to login. This combines all the above internal methods
    //Tests will call this single method to execute login functionality
    public void login(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

}
