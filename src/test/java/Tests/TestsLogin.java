package Tests;

import Pages.Homepage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestsLogin {

    WebDriver driver;

    @BeforeTest
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }


    @Test
    public void loginHappyPath() {

        Homepage homepage = new Homepage(driver);
        homepage.goToLoginPage();
        LoginPage loginPg = new LoginPage(driver);
        loginPg.enterEmail("ivan.ivan788@gmail.com");
        loginPg.enterPassword("awesomePass1@");
        loginPg.clickLoginButton();

        String emailDisplayed = homepage.getEmailDisplayedOnHomePageTxt();

        Assert.assertEquals(emailDisplayed, "ivan.ivan788@gmail.com",
                "The email displayed on homepage should be 'ivan.ivan788@gmail.com'");
    }

    @Test
    public void loginUnhappyPath1() {

        Homepage homepage = new Homepage(driver);
        homepage.goToLoginPage();
        LoginPage loginPg = new LoginPage(driver);
        loginPg.enterEmail("a");
        loginPg.enterPassword("awesomePass1@");
        loginPg.clickLoginButton();

        String enterValidEmailError = loginPg.getEnterValidEmailError();

        Assert.assertEquals(enterValidEmailError, "Please enter a valid email address.",
                "The message should say 'Please enter a valid email address.'");
    }

    @Test
    public void loginUnhappyPath2() {

        Homepage homepage = new Homepage(driver);
        homepage.goToLoginPage();
        LoginPage loginPg = new LoginPage(driver);
        loginPg.clickLoginButton();

        String loginUnsuccessfulError = loginPg.getLoginUnsuccesfulError();
        String noCustomerFoundError = loginPg.getNoCustomerFoundError();

        Assert.assertEquals(loginUnsuccessfulError, "Login was unsuccessful. Please correct the errors and try again.",
                "The message should say 'Login was unsuccessful. Please correct the errors and try again.'");

        Assert.assertEquals(noCustomerFoundError, "No customer account found",
                "The message should say 'No customer account found");
    }

    @Test
    public void loginUnhappyPath3 () {

        Homepage homepage = new Homepage(driver);
        homepage.goToLoginPage();
        LoginPage loginPg = new LoginPage(driver);
        loginPg.enterEmail("ivan.ivan788@gmail.com");
        loginPg.enterPassword("a");
        loginPg.clickLoginButton();

        String loginUnsuccessfulError = loginPg.getLoginUnsuccesfulError();
        String incorrectCredentialsError = loginPg.getIncorrectCredentialsError();

        Assert.assertEquals(loginUnsuccessfulError, "Login was unsuccessful. Please correct the errors and try again.",
                "The message should say 'Login was unsuccessful. Please correct the errors and try again.'");

        Assert.assertEquals(incorrectCredentialsError, "The credentials provided are incorrect",
                "The message should say 'The credentials provided are incorrect");
    }



    }

