package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    private WebDriver wd;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")
    WebElement registerPageLink;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    WebElement loginPageLink;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement booksPageLink;

    @FindBy (className = "account")
    WebElement emailDisplayedOnHomepage;


    public Homepage (WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    public void goToRegisterPage () {
        registerPageLink.click();
    }

    public void goToLoginPage () {
        loginPageLink.click();
    }

    public void goToBooksPage () {booksPageLink.click();}

    public String getEmailDisplayedOnHomePageTxt() {
        return emailDisplayedOnHomepage.getText();
    }
}
