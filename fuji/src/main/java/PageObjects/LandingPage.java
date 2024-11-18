package PageObjects;

import helpers.ElementHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends SuperPage{

    private static final Logger mylogger = LogManager.getLogger(LandingPage.class);

    public LandingPage(WebDriver driver) {
        SearchContext shadow = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
        PageFactory.initElements(shadow, this);
        this.driver=driver;
        mylogger.info("Landing Page Loaded");
    }

    @FindBy(how = How.CSS, using = "a[href='/list/mens_outerwear']")
    private WebElement mens_outwear_lnk;

    @FindBy(how = How.CSS, using = "a[href='/list/mens_tshirts']")
    private WebElement mens_tshirt_lnk;

    @FindBy(how = How.CSS, using = "a[aria-label='SHOP Home']")
    private WebElement shop_home_lnk;

    @FindBy(how = How.CSS, using = "a[href='/list/ladies_outerwear']")
    private WebElement womens_outwear_lnk;

    @FindBy(how = How.CSS, using = "a[href='/list/ladies_tshirts']")
    private WebElement womens_tshirt_lnk;

    @FindBy(how = How.CSS, using = "paper-icon-button[icon='shopping-cart']")
    private WebElement shopping_cart;




    public void click_on_shop() {
        elementHelpers.waitforelement_click(driver,shop_home_lnk,"Shop Home Link",mylogger);
    }

    public ProductListingPage click_on_mensoutwear(){

        elementHelpers.waitforelement_click(driver,mens_outwear_lnk,"Mens Outwear Link",mylogger);
        return new ProductListingPage(this.driver);
    }

    public ProductListingPage click_on_womensoutwear(){
        elementHelpers.waitforelement_click(driver,womens_outwear_lnk,"Womens Outwear Link",mylogger);

        return new ProductListingPage(this.driver);
    }

    public void click_on_menstshirts(){
        mens_tshirt_lnk.click();
    }

    public void click_on_womenstshirts(){
        womens_tshirt_lnk.click();
    }

    public CartPage click_on_cartspage()
    {
        elementHelpers.waitforelement_click(driver,shopping_cart,"Shopping Cart",mylogger);
        return new CartPage(this.driver);
    }
}
