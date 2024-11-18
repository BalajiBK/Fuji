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


public class FinishPage extends SuperPage {

    SearchContext _lowestShadowRoot;
    private static final Logger mylogger = LogManager.getLogger(FinishPage.class);

    public FinishPage(WebDriver driver){
        _waithelpers = new waithelpers();

        //This Element is inside 2 nested shadow DOM.
        String cssSelectorForHost1 = "shop-app[page='checkout']";
        String cssSelectorForHost2 = ".iron-selected";
        WebElement Elm = driver.findElement(By.cssSelector(cssSelectorForHost1));
        _waithelpers.waitforelement(driver,Elm);
        SearchContext shadow0 =Elm.getShadowRoot();

        WebElement Elm2 = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        _waithelpers.waitforelement(driver,Elm2);
        _lowestShadowRoot =Elm2.getShadowRoot();

        PageFactory.initElements(_lowestShadowRoot,this);
        this.driver = driver;
    }

    @FindBy(how = How.CSS, using = "p.1")
    private WebElement txt_democheckoutcomplete;

    @FindBy(how = How.CSS, using = "shop-button>a[href='/']")
    private WebElement btn_finish;

    @FindBy(how = How.CSS, using = "header[state='success'] > h1")
    private WebElement txt_thankyou;

    public void click_finish()
    {
        elementHelpers.waitforelement_click(driver,btn_finish,"Finish Button",mylogger);

    }

    public String get_thankyou_message()
    {
        _waithelpers.waitforelement_srchcntxt(driver,_lowestShadowRoot,By.cssSelector("header[state='success'] > h1"));
        elementHelpers.waitforelement(driver,txt_thankyou,"Thank You Message",mylogger);
        mylogger.info(txt_thankyou.getText());

        return txt_thankyou.getText();
    }




}
