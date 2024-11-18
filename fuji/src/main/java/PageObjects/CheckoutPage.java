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

import java.util.HashMap;

public class CheckoutPage extends SuperPage{

    private static final Logger mylogger = LogManager.getLogger(CheckoutPage.class);

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
        mylogger.info("CheckoutPage Loaded");
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
//        txt_accountemail.sendKeys(account_info_map.get("Email"));
        elementHelpers.waitforelement_sendkeys(driver,txt_accountemail,"Email",account_info_map.get("Email"),mylogger);

//        txt_accountPhone.sendKeys(account_info_map.get("Phone"));
        elementHelpers.waitforelement_sendkeys(driver,txt_accountPhone,"Phone",account_info_map.get("Phone"),mylogger);

//        txt_shipAddress.sendKeys(account_info_map.get("Address"));
        elementHelpers.waitforelement_sendkeys(driver,txt_shipAddress,"Address",account_info_map.get("Address"),mylogger);

//        txt_city.sendKeys(account_info_map.get("City"));
        elementHelpers.waitforelement_sendkeys(driver,txt_city,"City",account_info_map.get("City"),mylogger);

//        txt_state.sendKeys(account_info_map.get("State"));
        elementHelpers.waitforelement_sendkeys(driver,txt_state,"State",account_info_map.get("State"),mylogger);

//        txt_zip.sendKeys(account_info_map.get("Zip"));
        elementHelpers.waitforelement_sendkeys(driver,txt_zip,"Zip",account_info_map.get("Zip"),mylogger);


//        selectitemfromlist(slct_country,account_info_map.get("Country"));
        elementHelpers.selectitemfromlist(driver,slct_country,account_info_map.get("Country"),"Country_Dropdown",mylogger);

//        txt_cardholdername.sendKeys(account_info_map.get("Cardholder Name"));
        elementHelpers.waitforelement_sendkeys(driver,txt_cardholdername,"Cardholder Name",account_info_map.get("Cardholder Name"),mylogger);

//        txt_cardnumber.sendKeys(account_info_map.get("Card Number"));
        elementHelpers.waitforelement_sendkeys(driver,txt_cardnumber,"Card Number",account_info_map.get("Card Number"),mylogger);

//        selectitemfromlist(select_cardexpmnth,account_info_map.get("Expiry_Month"));
//        selectitemfromlist(select_cardexpyear,account_info_map.get("Expiry_Year"));

        elementHelpers.selectitemfromlist(driver,select_cardexpmnth,account_info_map.get("Expiry_Month"),"Expiry_Month",mylogger);
        elementHelpers.selectitemfromlist(driver,select_cardexpyear,account_info_map.get("Expiry_Year"),"Expiry_Year",mylogger);

//        txt_cvv.sendKeys(account_info_map.get("Cvv"));
        elementHelpers.waitforelement_sendkeys(driver,txt_cvv,"Cvv",account_info_map.get("Cvv"),mylogger);

//        btn_placeorder.click();
        elementHelpers.waitforelement_click(driver,btn_placeorder,"Place Order",mylogger);
        
        return new FinishPage(this.driver);

    }


}
