package fujiaut.definitions;

import PageObjects.*;
import helpers.excelhelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class Purchase_Definitions {

    private static WebDriver driver;
    public final static int TIMEOUT = 10;
    public LandingPage landingPage;
    public CheckoutPage checkoutPage;


    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        driver = new ChromeDriver(options);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));


    }

    @Given("User is on home page {string}")
    public void userIsOnHomePage(String my_url) {
        driver.get(my_url);
        landingPage=new LandingPage(driver);

    }

    @After
    public void teardown() {

        driver.quit();
    }

    @When("User Adds following item to the cart")
    public void userAddsFollowingItemToTheCart(DataTable myitem) {
        MensoutwearPage mensoutwearpage = landingPage.click_on_mensoutwear();
        ProductPage productspage = mensoutwearpage.clickon_Mens_Tech_Shell_Full_Zip();
        productspage.EnterSize("XL");
        productspage.EnterQuantity("2");
        productspage.AddToCart();

        landingPage.click_on_shop();
        mensoutwearpage = landingPage.click_on_womensoutwear();
        productspage = mensoutwearpage.clickon_Ladies_Modern_Stretch_Full_Zip();
        productspage.EnterSize("XS");
        productspage.EnterQuantity("3");
        productspage.AddToCart();



        landingPage.click_on_shop();
        CartPage cartPage=landingPage.click_on_cartspage();
        checkoutPage=cartPage.click_btn_checkout();

        System.out.println("Not Implemented"+myitem);
    }

    @Then("User should be able to view {int} Quantity of “Men's Tech Shell Full-Zip” of size {string} in the cart")
    public void userShouldBeAbleToViewQuantityOfMenSTechShellFullZipOfSizeInTheCart(int arg0, String arg1) {
        System.out.println("Not Implemented");
    }

    @When("User Adds {int} Quantity of size {string} of “Ladies Modern Stretch Full Zip” from category {string}")
    public void userAddsQuantityOfSizeOfLadiesModernStretchFullZipFromCategory(int arg0, String arg1, String arg2) {
        System.out.println("Not Implemented");
    }

    @Then("User should be able to view {int} Quantity of “Ladies Modern Stretch Full Zip” of size {string} in the cart")
    public void userShouldBeAbleToViewQuantityOfLadiesModernStretchFullZipOfSizeInTheCart(int arg0, String arg1) {
        System.out.println("Not Implemented");
    }

    @And("Verify the cart for the following")
    public void verifyTheCartForTheFollowing(DataTable cartitem) {
        System.out.println("Not Implemented"+cartitem);
    }

    @When("the user checksout the cart")
    public void theUserChecksoutTheCart() {
        System.out.println("Not Implemented");
    }

    @And("fill the account and payment information of {string}")
    public void fillTheAccountAndPaymentInformationOf(String arg0) throws IOException {
        HashMap<String, String> account_info_map=new excelhelper().readexcel("userinformation.xlsx");
        FinishPage finishPage=checkoutPage.enter_AccountInfo(account_info_map);
        finishPage.click_finish();

        landingPage.click_on_shop();

        landingPage.click_on_menstshirts();

        landingPage.click_on_shop();
        landingPage.click_on_womenstshirts();
        System.out.println("Not Implemented");
    }

    @And("place order")
    public void placeOrder() {
        System.out.println("Not Implemented");
    }

    @Then("Thank You message is seen")
    public void thankYouMessageIsSeen() {
        System.out.println("Not Implemented");
    }

    @And("click on Finish Button")
    public void clickOnFinishButton() {
        System.out.println("Not Implemented");
    }
}
