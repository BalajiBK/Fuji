package PageObjects;

import helpers.waithelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        String cssSelectorForHost1 = "shop-app[page='detail']";
        String cssSelectorForHost2 = "shop-detail[name='detail']";

        SearchContext shadow0 = driver.findElement(By.cssSelector(cssSelectorForHost1)).getShadowRoot();
        WebElement elm = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        new waithelpers().waitforelement(driver,elm);
        SearchContext shadow1 = elm.getShadowRoot();


        PageFactory.initElements(shadow1, this);
        this.driver = driver;

        //This Element is inside 2 nested shadow DOM.

        shadow1.findElement(By.cssSelector("#sizeSelect"));
    }

    @FindBy(how = How.CSS, using = "#sizeSelect")
    private WebElement sizeSelector;

    @FindBy(how = How.CSS, using = "#quantitySelect")
    private WebElement quantitySelector;

    @FindBy(how = How.CSS, using = "button[aria-label='Add this item to cart']")
    private WebElement btnAddToCart;



    public void EnterSize(String size) {
        sizeSelector.sendKeys(size);
    }

    public void EnterQuantity(String Qty) {
        quantitySelector.sendKeys(Qty);
    }

    public void AddToCart(){
        btnAddToCart.click();
    }
}
