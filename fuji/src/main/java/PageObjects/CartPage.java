package PageObjects;

import helpers.waithelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    waithelpers _waithelpers;
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
    }

    @FindBy(how = How.CSS, using = "a[href='/checkout']")
    private WebElement btn_checkout;

    public CheckoutPage click_btn_checkout()
    {
        btn_checkout.click();
        return new CheckoutPage(this.driver);
    }
}
