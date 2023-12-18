package utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class ReusableMethods {

    static WebDriverWait wait;
    static Duration duration = ofSeconds(15);

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//

    public static void clickFunction(WebElement clickElement) {
        elementWithFrame(clickElement);
        waitFor(1);
        wait = new WebDriverWait(Driver.getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOf(clickElement)).click();
    }//

    public static void assertionUrl(String expected) {
        Assert.assertEquals(expected, Driver.getDriver().getCurrentUrl());
    }//

    public static void assertionTxt(WebElement actual, String expected) {
        wait = new WebDriverWait(Driver.getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(), expected);
        System.out.println("Text : " + actual.getText());
    }//

    public static void jsScrollClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        wait = new WebDriverWait(Driver.getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        try {
            elementWithFrame(webElement);
            webElement.click();
        } catch (Exception e) {
            elementWithFrame(webElement);
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
        }
    }//

    public static void elementWithFrame(WebElement element) {
        String script = "arguments[0].style.border='3px solid red';";
        ((JavascriptExecutor) Driver.driver).executeScript(script, element);
    }
}
