package PageObjects;

import helpers.waithelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    WebDriver driver;
    waithelpers _waithelpers;
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
        SearchContext shadow1 =Elm2.getShadowRoot();

        PageFactory.initElements(shadow1,this);
        this.driver = driver;
    }

    @FindBy(how = How.CSS, using = "p.1")
    private WebElement txt_democheckoutcomplete;

    @FindBy(how = How.CSS, using = "shop-button")
    private WebElement btn_finish;

    @FindBy(how = How.CSS, using = "h1.1")
    private WebElement txt_thankyou;

    public void click_finish()
    {
        btn_finish.click();
    }




}
