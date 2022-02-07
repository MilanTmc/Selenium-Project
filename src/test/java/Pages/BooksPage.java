package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BooksPage {

    WebDriver wd;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]")
    WebElement computingBook;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]")
    WebElement copyOfComputingBook;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]")
    WebElement fictionBook;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]")
    WebElement fictionFxBook;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[5]/div[1]/div[1]")
    WebElement healthBook;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/select[1]")
    WebElement gridListDropdown;

    @FindBy (xpath = "//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[3]/select[1]")
    WebElement numberOfProductsOnPageDropdown;

    @FindBy (className = "item-box" )
    WebElement oneProduct;



    public BooksPage (WebDriver wd) {
        PageFactory.initElements(wd, this);
    }

    public void clickOnComputingBook () {
         computingBook.click();
    }

    public void selectListFromDropdown () throws InterruptedException {
        Select chooseList = new Select(this.gridListDropdown);
        Thread.sleep(2000);
        chooseList.selectByVisibleText("List");
    }

    public void selectGridFromDropdown () throws InterruptedException {
        Select chooseGrid = new Select(this.gridListDropdown);
        Thread.sleep(2000);
        chooseGrid.selectByVisibleText("Grid");
    }

    public void select4ProductsDisplayed () throws InterruptedException {
        Select chooseFour = new Select(this.numberOfProductsOnPageDropdown);
        Thread.sleep(2000);
        chooseFour.selectByVisibleText("4");
    }

    public void select8ProductsDisplayed () throws InterruptedException {
        Select chooseFour = new Select(this.numberOfProductsOnPageDropdown);
        Thread.sleep(2000);
        chooseFour.selectByVisibleText("8");
    }


}
