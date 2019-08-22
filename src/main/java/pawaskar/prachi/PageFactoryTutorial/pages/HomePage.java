package pawaskar.prachi.PageFactoryTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    // List all the elements to be used from the page
    WebDriver driver;

    //Initialize elements different then POM, here is done using @FindBy instead of "By" object
    @FindBy(id = "signin_button")
    WebElement signinButton;

    // Constructor to initialize the driver
    public  HomePage(WebDriver driver){
        //Links the driver from test class and the driver from this class
        this.driver = driver;
        //This initElements method will create  all WebElements,
        // Otherwise Web elments do not get initialize and hence no value of xpath/id etc is assigned to web element
        // Results in NPE on web element usage is not used
        PageFactory.initElements(driver, this);
    }

    //Go to Sign-in page
    public void goToSignInPage(){
        //enter user name
        //Use webelement directly instead driver.By syntax as in POM
        signinButton.click();
    }


}
