package helpers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementHelpers {

    public waithelpers wait;

    public ElementHelpers() {
        this.wait = new waithelpers();
    }


    public void waitforelement_click(WebDriver driver, WebElement wb_elm,String elementname,Logger logger)
    {
        this.wait.waitforelement(driver,wb_elm);
        wb_elm.click();
        logger.info("Clicked on "+elementname);
    }

    public void waitforelement_sendkeys(WebDriver driver, WebElement wb_elm,String elementname,String value,Logger logger)
    {
        this.wait.waitforelement(driver,wb_elm);
        wb_elm.sendKeys(value);
        logger.info("Entered value "+value+" in field "+elementname);
    }

    public void selectitemfromlist(WebDriver driver,WebElement selectElement,String itemtobeselected,String elementname,Logger logger)
    {
        this.wait.waitforelement(driver,selectElement);
        Select select = new Select(selectElement);
        select.selectByValue(itemtobeselected);
        logger.info("Selected "+itemtobeselected+" from dropdown "+elementname);
    }

    public void waitforelement(WebDriver driver, WebElement txtThankyou, String thankYouMessage, Logger mylogger) {
        this.wait.waitforelement(driver, txtThankyou);
        mylogger.info("Waited for element "+thankYouMessage);
    }
}
