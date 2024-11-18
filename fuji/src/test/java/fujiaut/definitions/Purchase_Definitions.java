package fujiaut.definitions;

import PageObjects.*;
import fujiaut.datamodels.product;
import fujiaut.datamodels.products_catalog;
import helpers.excelhelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purchase_Definitions {

    private static WebDriver driver;
    public final static int TIMEOUT = 10;
    public LandingPage landingPage;
    public CheckoutPage checkoutPage;
    public CartPage cartPage;
    public FinishPage finishPage;
    public products_catalog productcatalog = new products_catalog();

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
    public void userAddsFollowingItemToTheCart(DataTable mytable) {
        List<Map<String, String>> rows = mytable.asMaps(String.class, String.class);
        ProductListingPage productListingPage=null;
        ProductPage productspage=null;
        for (Map<String, String> columns : rows) {
            productcatalog.addProduct(new product(columns.get("item Name"), columns.get("Size"), columns.get("Quantity"), columns.get("Total"), columns.get("Category")));
        }
        for (product item : productcatalog.getProducts()) {
            landingPage.click_on_shop();
            if (item.getCategory().equals("Men's Outerwear")) {
                productListingPage = landingPage.click_on_mensoutwear();
                productspage = productListingPage.clickon_Mens_Tech_Shell_Full_Zip();
            } else if (item.getCategory().equals("Ladies Outerwear")) {
                productListingPage = landingPage.click_on_womensoutwear();
                productspage = productListingPage.clickon_Ladies_Modern_Stretch_Full_Zip();
            }

            productspage.EnterSize(item.getSize());
            productspage.EnterQuantity(item.getQuantity());
            productspage.AddToCart();


        }

        landingPage.click_on_shop();



    }

    @And("Verify the cart for the following")
    public void verifyTheCartForTheFollowing(DataTable cartitem) {

        cartPage=landingPage.click_on_cartspage();
        // Verify the cart
    }

    @When("the user checksout the cart")
    public void theUserChecksoutTheCart() {

        checkoutPage=cartPage.click_btn_checkout();
    }

    @And("fill the account and payment information of {string} and place order")
    public void fillTheAccountAndPaymentInformationOf(String arg0) throws IOException {
        HashMap<String, String> account_info_map=new excelhelper().readexcel(arg0+".xlsx");
        finishPage=checkoutPage.enter_AccountInfo(account_info_map);
    }



    @And("finish the order")
    public void clickOnFinishButton() {
        finishPage.click_finish();
    }

    @Then("verify Thank You message")
    public void verifyThankYouMessage() {
//        Assert.assertTrue(finishPage.txt_thankyou.isDisplayed());
        String msg = finishPage.get_thankyou_message();
        Assert.assertEquals(msg,"Thank you");
    }
}
