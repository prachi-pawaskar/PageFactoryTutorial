package pawaskar.prachi.PageFactoryTutorial;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pawaskar.prachi.PageFactoryTutorial.lib.Base;
import pawaskar.prachi.PageFactoryTutorial.pages.DefaultPageAfterLogin;
import pawaskar.prachi.PageFactoryTutorial.pages.HomePage;
import pawaskar.prachi.PageFactoryTutorial.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class TestsToExecute extends Base {

    //Declarations
    HomePage homePage;
    LoginPage loginPage;
    DefaultPageAfterLogin defaultPageAfterLogin;

    //Run the test to login and verify that the dashboard is loaded by default
    @Test
    public void verifyLogin() throws InterruptedException {
        //Home Page actions
        homePage = new HomePage(driver);
        homePage.goToSignInPage();
        //Login page actions
        loginPage = new LoginPage(driver);
        loginPage.login("username","password");
        //Default landing page options
        defaultPageAfterLogin = new DefaultPageAfterLogin(driver);
        Boolean isDisplayed = defaultPageAfterLogin.verifyLandingPage();
        assertTrue(isDisplayed);
    }

}
