package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver wd;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/input[1]")
    WebElement email;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[3]/input[1]")
    WebElement password;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")
    WebElement loginButton;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/span[1]/span[1]")
    WebElement enterValidEmailError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]")
    WebElement loginUnsuccessfulError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/ul[1]/li[1]")
    WebElement noCustomerFoundError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/ul[1]/li[1]")
    WebElement incorrectCredentialsError;

    public LoginPage (WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    public void enterEmail (String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void enterPassword (String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginButton () {
        loginButton.click();
    }

    public String getEnterValidEmailError() {return enterValidEmailError.getText();}

    public String getLoginUnsuccesfulError() {return loginUnsuccessfulError.getText();}

    public String getNoCustomerFoundError() {return noCustomerFoundError.getText();}

    public String getIncorrectCredentialsError() {return incorrectCredentialsError.getText();}



}
