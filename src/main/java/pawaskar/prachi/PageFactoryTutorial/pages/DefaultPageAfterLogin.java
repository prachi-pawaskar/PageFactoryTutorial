package pawaskar.prachi.PageFactoryTutorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DefaultPageAfterLogin {

    // List all the elements to be used from the page
    WebDriver driver;

    //Initialize elements different then POM, here is done using @FindBy instead of "By" object
    // POM example is "By accountsSummaryTab = By.xpath("//ul/li[@id=\"account_summary_tab\"]/a");"
    @FindBy(xpath = "//ul/li[@id=\"account_summary_tab\"]/a")
    WebElement accountsSummaryTab;

    // Constructor to initialize the driver
    public  DefaultPageAfterLogin(WebDriver driver){
        //Links the driver from test class and the driver from this class
        this.driver = driver;
        // Otherwise Web elments do not get initialize and hence no value of xpath/id etc is assigned to web element
        // Results in NPE on web element usage is not used
        PageFactory.initElements(driver, this);
    }

    //Method to verify that the login
    //Tests will call this single method to execute login functionality
    public Boolean verifyLandingPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        Boolean isDisplayed = accountsSummaryTab.isDisplayed();

        return isDisplayed;
    }

}
