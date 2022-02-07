package Tests;

import Pages.BooksPage;
import Pages.Homepage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestBookPage {

    WebDriver driver;

    @BeforeTest
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

//    @Test
//    public void openProductPage1 () {
//
//        Homepage homepage = new Homepage(driver);
//        homepage.goToBooksPage();
//        BooksPage booksPg = new BooksPage(driver);
//        booksPg.clickOnComputingBook();
//    }

    @Test
    public void displayProductsInListView () throws InterruptedException {

        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.selectListFromDropdown();

        Assert.assertTrue(driver.findElement(By.className("product-list")).isDisplayed());

    }

    @Test
    public void displayProductsInGridView () throws InterruptedException {

        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.selectGridFromDropdown();

        Assert.assertTrue(driver.findElement(By.className("product-grid")).isDisplayed());
    }

    @Test
    public void displayFourProducts () throws InterruptedException {


        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.select4ProductsDisplayed();


        int numberOfelements = driver.findElements(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]")).size();


        Assert.assertEquals(numberOfelements, 4);
    }

}
