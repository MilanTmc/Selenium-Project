package Tests;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestsRegister {

    WebDriver driver;

    @BeforeTest
    public void initialize () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
    }

    @AfterTest
    public void close () throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }


    @Test
    public void registerHappyPath () {

        Homepage homepage = new Homepage(driver);
        homepage.goToRegisterPage();
        RegisterPage registerPg = new RegisterPage(driver);
        registerPg.clickGender();
        registerPg.clickRegisterButton();
        registerPg.enterFirstName("Ivan");
        registerPg.enterLastName("Ivanov");
        registerPg.enterEmail("ivan.ivan788@gmail.com");
        registerPg.enterPassword("awesomePass1@");
        registerPg.confirmPass("awesomePass1@");
        registerPg.clickRegisterButton();

        String successRegTxt = registerPg.getSuccessfulRegistrationText();

        Assert.assertEquals(successRegTxt, "Your registration completed",
                "The message should say 'Your registration completed'");
    }

    @Test
    public void registerUnhappyPath1 () {

        Homepage homepage = new Homepage(driver);
        homepage.goToRegisterPage();
        RegisterPage registerPg = new RegisterPage(driver);
        registerPg.clickGender();
        registerPg.clickRegisterButton();
        registerPg.enterFirstName("Ivan");
        registerPg.enterLastName("Ivanov");
        registerPg.enterEmail("ivan.ivan788@gmail.com");
        registerPg.enterPassword("awesomePass1@");
        registerPg.confirmPass("awesomePass1@");
        registerPg.clickRegisterButton();

        String emailAlreadyExistsError = registerPg.getEmailAlreadyExistsError();

        Assert.assertEquals(emailAlreadyExistsError, "The specified email already exists",
                "The message should say 'The specified email already exists'");
    }

    @Test
    public void registerUnhappyPath2 () {

        Homepage homepage = new Homepage(driver);
        homepage.goToRegisterPage();
        RegisterPage registerPg = new RegisterPage(driver);
        registerPg.clickGender();
        registerPg.enterFirstName("Ivan");
        registerPg.enterLastName("Ivanov");
        registerPg.enterEmail("a");
        registerPg.enterPassword("awesomePass1@");
        registerPg.confirmPass("awesomePass1@");
        registerPg.clickRegisterButton();

        String wrongEmailmsg = registerPg.getWrongEmailMessage();

        Assert.assertEquals(wrongEmailmsg, "Wrong email",
                "The message displayed should be 'Wrong email'");

    }

    @Test
    public void registerUnhappyPath3 () {

        Homepage homepage = new Homepage(driver);
        homepage.goToRegisterPage();
        RegisterPage registerPg = new RegisterPage(driver);
        registerPg.clickRegisterButton();

        String firstNameError = registerPg.getFirstNameRequiredError();
        String lastNameError = registerPg.getLastNameRequiredError();
        String emailError = registerPg.getEmailRequiredError();
        String usernameError = registerPg.getPasswordRequiredError();
        String passwordError = registerPg.getConfirmPasswordRequiredError();

        Assert.assertEquals(firstNameError, "First name is required.");
        Assert.assertEquals(lastNameError, "Last name is required.");
        Assert.assertEquals(emailError, "Email is required.");
        Assert.assertEquals(usernameError, "Password is required.");
        Assert.assertEquals(passwordError, "Password is required.");
    }

    @DataProvider (name = "differentPasswordLengths")
    public Object[][] differentPasswordLengths() {
        return new Object[][]{
                {"a","a"},
                {"ab","ab"},
                {"abc","abc"},
                {"abcd", "abcd"},
                {"abcde", "abcde"}
        };
    }

    @Test (dataProvider = "differentPasswordLengths")
    public void registerUnhappyPath4 (String password, String confirmPassword) {

        Homepage homepage = new Homepage(driver);
        homepage.goToRegisterPage();
        RegisterPage registerPg = new RegisterPage(driver);
        registerPg.clickGender();
        registerPg.enterFirstName("Ivan");
        registerPg.enterLastName("Ivanov");
        registerPg.enterEmail("ivan.ivan788@gmail.com");
        registerPg.enterPassword(password);
        registerPg.confirmPass(confirmPassword);
        registerPg.clickRegisterButton();

        String passwordTooShort = registerPg.getPasswordTooShortError();

        Assert.assertEquals(passwordTooShort, "The password should have at least 6 characters.");

    }



}

