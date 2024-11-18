package PageObjects;

import helpers.ElementHelpers;
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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage extends SuperPage {

    private static final Logger mylogger = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver)
    {
        //This Element is inside 2 nested shadow DOM.
        String cssSelectorForHost1 = "shop-app[page='cart']";
        String cssSelectorForHost2 = ".iron-selected";
        _waithelpers = new waithelpers();
        WebElement Elm = driver.findElement(By.cssSelector(cssSelectorForHost1));
        _waithelpers.waitforelement(driver,Elm);
        SearchContext shadow0 =Elm.getShadowRoot();

        WebElement Elm2 = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        _waithelpers.waitforelement(driver,Elm2);
        SearchContext shadow1 =Elm2.getShadowRoot();

        shadow1.findElement(By.cssSelector("a[href='/checkout']"));

        PageFactory.initElements(shadow1,this);
        this.driver=driver;
        mylogger.info("CartPage Loaded");
    }

    @FindBy(how = How.CSS, using = "a[href='/checkout']")
    private WebElement btn_checkout;

    @FindBy(how = How.CSS, using = "div.flex")
    private WebElement tbl_cart;

    public CheckoutPage click_btn_checkout()
    {
        elementHelpers.waitforelement_click(driver,btn_checkout,"Checkout",mylogger);
        return new CheckoutPage(this.driver);
    }

    public boolean verifyTheCart(String itemName,String size,String quantity,String total,int lineitem) {


        //This Element is inside 3 nested shadow DOM.
        String cssSelectorForHost1 = "shop-app[page='cart']";
        String cssSelectorForHost2 = "shop-cart[name='cart']";
        String cssSelectorForHost3 = " div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > shop-cart-item:nth-child(+"+lineitem+")";

        WebElement cart_first_level_host = driver.findElement(By.cssSelector(cssSelectorForHost1));
        elementHelpers.waitforelement(driver,cart_first_level_host,"Cart First Level Host",mylogger);
        SearchContext shadow0 = cart_first_level_host.getShadowRoot();

        WebElement cart_second_level_host = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        elementHelpers.waitforelement(driver,cart_second_level_host,"Cart Second Level Host",mylogger);
        SearchContext shadow1 = cart_second_level_host.getShadowRoot();

        WebElement cart_third_level_host = shadow1.findElement(By.cssSelector(cssSelectorForHost3));
        elementHelpers.waitforelement(driver,cart_third_level_host,"Cart Third Level Host",mylogger);
        SearchContext shadow2 = cart_third_level_host.getShadowRoot();


        WebElement first_item_qty=shadow2.findElement(By.cssSelector("#quantitySelect"));
        Select select = new Select(first_item_qty);
        List<WebElement> selectedOptionList = select.getAllSelectedOptions();
        String first_item_qty_selected=selectedOptionList.get(0).getText();
        mylogger.info("Selected Item Quantity: "+first_item_qty_selected);
        if (!first_item_qty_selected.equals(quantity))
        {
            mylogger.info("Quantity Mismatch actual: "+first_item_qty_selected+" expected: "+quantity);
            return false;
        } else {
            mylogger.info("Quantity Matched");
        }

        WebElement selected_item=shadow2.findElement(By.cssSelector(" div:nth-child(3) > div:nth-child(1) > a:nth-child(1)"));
        String item_name=selected_item.getText();
        mylogger.info("Selected first Item Name: "+item_name);

        if (!item_name.equals(itemName))
        {
            mylogger.info("Item Name Mismatch actual: "+item_name+" expected: "+itemName);
            return false;
        } else {
            mylogger.info("Item Name Matched");
        }


        WebElement first_item_size=shadow2.findElement(By.cssSelector(".size"));
        String item_size=first_item_size.getText();
        mylogger.info("Selected first Item Size: "+item_size);

        if (!item_size.contains(size))
        {
            mylogger.info("Item Size Mismatch actual: "+item_size+" expected: "+size);
            return false;
        } else {
            mylogger.info("Item Size Matched");
        }

        WebElement first_item_price=shadow2.findElement(By.cssSelector(".price"));
        String item_price=first_item_price.getText();
        mylogger.info("Selected first Item Price: "+item_price);

        if (!item_price.contains(total))
        {
            mylogger.info("Item Price Mismatch actual: "+item_price+" expected: "+total);
            return false;
        } else {
            mylogger.info("Item Price Matched");
        }
        mylogger.info("All Items Matched");
        return true;

    }
}
