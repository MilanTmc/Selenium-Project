package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver wd;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/input[1]")
    WebElement genderMale;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[2]/input[1]")
    WebElement firstName;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[3]/input[1]")
    WebElement lastName;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[4]/input[1]")
    WebElement email;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[1]/input[1]")
    WebElement password;

    @FindBy(xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[2]/input[1]")
    WebElement confirmPassword;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[4]/input[1]")
    WebElement registerButton;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]")
    WebElement successfulRegistrationText;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[4]/span[2]/span[1]")
    WebElement wrongEmailmessage;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[2]/span[2]")
    WebElement firstNameRequiredError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[3]/span[2]/span[1]")
    WebElement lastNameRequiredError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[4]/span[2]/span[1]")
    WebElement emailRequiredError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[2]/span[1]")
    WebElement passwordRequiredError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[2]/span[2]/span[1]")
    WebElement confirmPasswordRequiredError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[2]/span[1]")
    WebElement passwordTooShortError;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]")
    WebElement emailAlreadyExistsError;

    public RegisterPage(WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    public void clickGender () {
        genderMale.click();
    }

    public void enterFirstName (String firstNm) {
        firstName.sendKeys(firstNm);
    }

    public void enterLastName (String lastNm) {
        lastName.sendKeys(lastNm);
    }

    public void enterEmail (String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void enterPassword (String pass) {
        password.sendKeys(pass);
    }

    public void confirmPass (String pass) {
        confirmPassword.sendKeys(pass);
    }

    public void clickRegisterButton () {
        registerButton.click();
    }

    public String getSuccessfulRegistrationText () {
       return successfulRegistrationText.getText();
    }

    public String getWrongEmailMessage () { return wrongEmailmessage.getText();}

    public String getFirstNameRequiredError () {return firstNameRequiredError.getText();}

    public String getLastNameRequiredError () {return lastNameRequiredError.getText();}

    public String getEmailRequiredError () {return emailRequiredError.getText();}

    public String getPasswordRequiredError () {return passwordRequiredError.getText();}

    public String getConfirmPasswordRequiredError () {return confirmPasswordRequiredError.getText();}

    public String getPasswordTooShortError () {return passwordTooShortError.getText();}

    public String getEmailAlreadyExistsError () {return emailAlreadyExistsError.getText();}




}
