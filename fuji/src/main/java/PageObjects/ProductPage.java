package PageObjects;

import helpers.waithelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProductPage extends SuperPage {
    WebDriver driver;
    private static final Logger mylogger = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        String cssSelectorForHost1 = "shop-app[page='detail']";
        String cssSelectorForHost2 = "shop-detail[name='detail']";

        SearchContext shadow0 = driver.findElement(By.cssSelector(cssSelectorForHost1)).getShadowRoot();
        WebElement elm = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        new waithelpers().waitforelement(driver,elm);
        SearchContext shadow1 = elm.getShadowRoot();


        PageFactory.initElements(shadow1, this);
        this.driver = driver;


        mylogger.info("ProductPage Loaded");
    }

    @FindBy(how = How.CSS, using = "#sizeSelect")
    private WebElement sizeSelector;

    @FindBy(how = How.CSS, using = "#quantitySelect")
    private WebElement quantitySelector;

    @FindBy(how = How.CSS, using = "button[aria-label='Add this item to cart']")
    private WebElement btnAddToCart;



    public void EnterSize(String size) {
//        sizeSelector.sendKeys(size);
        elementHelpers.waitforelement_sendkeys(driver,sizeSelector,"Size",size,mylogger);
    }

    public void EnterQuantity(String Qty) {
//        quantitySelector.sendKeys(Qty);
        elementHelpers.waitforelement_sendkeys(driver,quantitySelector,"Quantity",Qty,mylogger);
    }

    public void AddToCart(){
//        btnAddToCart.click();
        elementHelpers.waitforelement_click(driver,btnAddToCart,"Add to Cart",mylogger);
    }
}
