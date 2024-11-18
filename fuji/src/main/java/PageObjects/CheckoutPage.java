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

import java.util.HashMap;

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

    public FinishPage enter_AccountInfo(HashMap<String,String> account_info_map)
    {
//        Email
//                Phone
//        Address
//                City
//        State
//                Zip
//        Country
//        Cardholder Name
//        Card Number
//        Expiry_Month
//                Expiry_Year
//        Cvv
        txt_accountemail.sendKeys(account_info_map.get("Email"));
        txt_accountPhone.sendKeys(account_info_map.get("Phone"));

//        b. Shipping Address
//#  i. Address- 1 abc street
//#  ii. City- abc
//#  iii. State-abc
//#  iv. Zip-123456
//#  v. Country-Canada


        txt_shipAddress.sendKeys(account_info_map.get("Address"));
        txt_city.sendKeys(account_info_map.get("City"));
        txt_state.sendKeys(account_info_map.get("State"));
        txt_zip.sendKeys(account_info_map.get("Zip"));

        selectitemfromlist(slct_country,account_info_map.get("Country"));


//        #  i. Cardholder Name – ABC ABC
//#  ii. Card Number - 1111111111111111
//#  iii. Expiry – Feb 2026
//#  iv. CVV- 123
        txt_cardholdername.sendKeys(account_info_map.get("Cardholder Name"));
        txt_cardnumber.sendKeys(account_info_map.get("Card Number"));

        selectitemfromlist(select_cardexpmnth,account_info_map.get("Expiry_Month"));
        selectitemfromlist(select_cardexpyear,account_info_map.get("Expiry_Year"));

        txt_cvv.sendKeys(account_info_map.get("Cvv"));


        btn_placeorder.click();

        return new FinishPage(this.driver);

    }

    public void selectitemfromlist(WebElement selectElement,String itemtobeselected)
    {
        Select select = new Select(selectElement);
        select.selectByValue(itemtobeselected);
    }
}
