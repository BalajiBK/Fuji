package PageObjects;

import helpers.waithelpers;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage extends SuperPage{
    WebDriver driver;
    waithelpers _waithelpers;
    private static final Logger mylogger = LogManager.getLogger(ProductListingPage.class);

    public ProductListingPage(WebDriver driver)
    {
//        //This Element is inside 2 nested shadow DOM.
        String cssSelectorForHost1 = "shop-app[page='list']";
        String cssSelectorForHost2 = "shop-list[name='list']";
        _waithelpers = new waithelpers();
        WebElement Elm = driver.findElement(By.cssSelector(cssSelectorForHost1));
        _waithelpers.waitforelement(driver,Elm);
        SearchContext shadow0 =Elm.getShadowRoot();

        WebElement Elm2 = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        _waithelpers.waitforelement(driver,Elm2);
        SearchContext shadow1 =Elm2.getShadowRoot();


        PageFactory.initElements(shadow1,this);
        this.driver=driver;

        mylogger.info("ProductListingPage Loaded");
    }

    @FindBy(how = How.CSS, using = "a[href='/detail/mens_outerwear/Men+s+Tech+Shell+Full-Zip']")
    private WebElement Mens_Tech_Shell_Full_Zip;

    @FindBy(how = How.CSS, using = "a[href='/detail/ladies_outerwear/Ladies+Modern+Stretch+Full+Zip']")
    private WebElement Womens_Tech_Shell_Full_Zip;

    public ProductPage clickon_Mens_Tech_Shell_Full_Zip()
    {

        elementHelpers.waitforelement_click(driver,Mens_Tech_Shell_Full_Zip,"Mens_Tech_Shell_Full_Zip",mylogger);
        return new ProductPage(this.driver);
    }

    public ProductPage clickon_Ladies_Modern_Stretch_Full_Zip()
    {
        elementHelpers.waitforelement_click(driver,Womens_Tech_Shell_Full_Zip,"Womens_Tech_Shell_Full_Zip",mylogger);
        return new ProductPage(this.driver);
    }





}
