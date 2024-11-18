package PageObjects;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver) {
        SearchContext shadow = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
        PageFactory.initElements(shadow, this);
        this.driver=driver;
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
        shop_home_lnk.click();
    }

    public MensoutwearPage click_on_mensoutwear(){
        System.out.println("Using the shadow context driver to find element");
        mens_outwear_lnk.click();
        return new MensoutwearPage(this.driver);
    }

    public MensoutwearPage click_on_womensoutwear(){
        womens_outwear_lnk.click();
        return new MensoutwearPage(this.driver);
    }

    public void click_on_menstshirts(){
        mens_tshirt_lnk.click();
    }

    public void click_on_womenstshirts(){
        womens_tshirt_lnk.click();
    }

    public CartPage click_on_cartspage()
    {
        shopping_cart.click();
        return new CartPage(this.driver);
    }
}
