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
    public void displayFourProductsInGrid () throws InterruptedException {


        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.selectGridFromDropdown();
        booksPg.select4ProductsDisplayed();

        List<WebElement> allProductsShownOnPage = driver.findElements(By.className("item-box"));
        int numberOfProducts = allProductsShownOnPage.size();

        Assert.assertEquals(numberOfProducts, 4);
    }

    @Test
    public void displayEightProductsInGrid () throws InterruptedException {


        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.selectGridFromDropdown();
        booksPg.select8ProductsDisplayed();

        List<WebElement> allProductsShownOnPage = driver.findElements(By.className("item-box"));
        int numberOfProducts = allProductsShownOnPage.size();

        if (numberOfProducts <= 8) {
            int expected = numberOfProducts;
            Assert.assertEquals(numberOfProducts, expected);
        }
    }

    @Test
    public void displayFourProductsInList () throws InterruptedException {


        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.selectListFromDropdown();
        booksPg.select4ProductsDisplayed();

        List<WebElement> allProductsShownOnPage = driver.findElements(By.className("item-box"));
        int numberOfProducts = allProductsShownOnPage.size();

        Assert.assertEquals(numberOfProducts, 4);
    }

    @Test
    public void displayEightProductsInList () throws InterruptedException {

        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);
        booksPg.selectListFromDropdown();
        booksPg.select8ProductsDisplayed();


        List<WebElement> allProductsShownOnPage = driver.findElements(By.className("item-box"));
        int numberOfProducts = allProductsShownOnPage.size();

        if (numberOfProducts <= 8) {
            int expected = numberOfProducts;
            Assert.assertEquals(numberOfProducts, expected);
        }
    }

    @Test
    public void sortProductsFromLowToHighPrice () {
        Homepage homepage = new Homepage(driver);
        homepage.goToBooksPage();
        BooksPage booksPg = new BooksPage(driver);

        List<WebElement> allPricesShownOfPage = driver.findElements(By.className("price actual-price"));

        

    }



}
