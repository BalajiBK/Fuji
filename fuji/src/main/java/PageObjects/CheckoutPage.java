package PageObjects;

import helpers.waithelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    WebDriver driver;
    waithelpers _waithelpers;
    public CheckoutPage(WebDriver driver)
    {
        //This Element is inside 2 nested shadow DOM.
        String cssSelectorForHost1 = "shop-app[page='checkout']";
        String cssSelectorForHost2 = ".iron-selected";
        _waithelpers = new waithelpers();
        WebElement Elm = driver.findElement(By.cssSelector(cssSelectorForHost1));
        _waithelpers.waitforelement(driver,Elm);
        SearchContext shadow0 =Elm.getShadowRoot();

        WebElement Elm2 = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
        _waithelpers.waitforelement(driver,Elm2);
        SearchContext shadow1 =Elm2.getShadowRoot();


        PageFactory.initElements(shadow1,this);
        this.driver = driver;
    }

    @FindBy(how = How.CSS, using = "#accountEmail")
    private WebElement txt_accountemail;

    @FindBy(how = How.CSS, using = "#accountPhone")
    private WebElement txt_accountPhone;

    @FindBy(how = How.CSS, using = "#shipAddress")
    private WebElement txt_shipAddress;

    @FindBy(how = How.CSS, using = "#shipCity")
    private WebElement txt_city;

    @FindBy(how = How.CSS, using = "#shipState")
    private WebElement txt_state;

    @FindBy(how = How.CSS, using = "#shipZip")
    private WebElement txt_zip;

    @FindBy(how = How.CSS, using = "#shipCountry")
    private WebElement slct_country;

    @FindBy(how = How.CSS, using = "#ccName")
    private WebElement txt_cardholdername;

    @FindBy(how = How.CSS, using = "#ccNumber")
    private WebElement txt_cardnumber;


    @FindBy(how = How.CSS, using = "#ccExpMonth")
    private WebElement select_cardexpmnth;

    @FindBy(how = How.CSS, using = "#ccExpYear")
    private WebElement select_cardexpyear;

    @FindBy(how = How.CSS, using = "#ccCVV")
    private WebElement txt_cvv;

    @FindBy(how = How.CSS,using = "input[value='Place Order']")
    private WebElement btn_placeorder;

    public FinishPage enter_AccountInfo()
    {
        txt_accountemail.sendKeys("abc@abc.com");
        txt_accountPhone.sendKeys("1111111111");
//        b. Shipping Address
//#  i. Address- 1 abc street
//#  ii. City- abc
//#  iii. State-abc
//#  iv. Zip-123456
//#  v. Country-Canada


        txt_shipAddress.sendKeys("1 abc street");
        txt_city.sendKeys("abc");
        txt_state.sendKeys("abc");
        txt_zip.sendKeys("123456");

        selectitemfromlist(slct_country,"CA");


//        #  i. Cardholder Name – ABC ABC
//#  ii. Card Number - 1111111111111111
//#  iii. Expiry – Feb 2026
//#  iv. CVV- 123
        txt_cardholdername.sendKeys("ABC ABC");
        txt_cardnumber.sendKeys("1111111111111111");

        selectitemfromlist(select_cardexpmnth,"02");
        selectitemfromlist(select_cardexpyear,"2026");

        txt_cvv.sendKeys("123");


        btn_placeorder.click();

        return new FinishPage(this.driver);

    }

    public void selectitemfromlist(WebElement selectElement,String itemtobeselected)
    {
        Select select = new Select(selectElement);
        select.selectByValue(itemtobeselected);
    }
}
