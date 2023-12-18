package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.*;

public class BackgroundPage {

    public BackgroundPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elements;
    public void elementsClick() {
        clickFunction(elements);
    }



    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement forms;
    public void formsClick() {
       clickFunction(forms);
    }




    public void urlAssertion() {
        assertionUrl("https://demoqa.com/");
    }
}
