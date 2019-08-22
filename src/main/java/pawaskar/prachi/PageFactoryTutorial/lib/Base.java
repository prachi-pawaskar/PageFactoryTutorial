package pawaskar.prachi.PageFactoryTutorial.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class Base {

    /** This class sets the driver up and shuts it down **/

    public WebDriver driver;

    //Runs once before every Test CLASS
    @BeforeTest
    public void beforeTest(){
        //Get the driver path
        String resourceFilePath = "src/main/java/pawaskar/prachi/PageFactoryTutorial/drivers";
        String resourceURL = new File(resourceFilePath).getAbsolutePath();
        //Set the driver path
        System.setProperty("webdriver.chrome.driver", resourceURL +"/chromedriver.exe");
        //Initialize browser
        // To disable pop up: Loading of unpacked extensions is disabled by the administrator
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");
    }

    //Shut down the browser
    @AfterTest
    public void afterTest(){
        driver.close();
    }

}
