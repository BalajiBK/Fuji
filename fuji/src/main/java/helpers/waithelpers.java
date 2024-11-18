package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waithelpers {

    public void waitforelement(WebDriver driver, WebElement wb_elm)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> wb_elm.isDisplayed());
    }

    public void waitforelement_srchcntxt(WebDriver driver,SearchContext shadowRoot, By wb_elm_by)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(wb_elm_by)));

    }
}
