package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BackgroundPage;
import utilities.ConfigReader;
import utilities.Driver;

public class BackgroundSteps {

    BackgroundPage page = new BackgroundPage();

    @Given("visit to url")
    public void visitToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }


    @Then("elements basligina tiklar")
    public void elementsBasliginaTiklar() {
        page.elementsClick();
    }


    @Then("forms basligina tiklar")
    public void formsBasliginaTiklar() {
        page.formsClick();
    }


    @Then("sayfaya gidildigini dogrular")
    public void sayfayaGidildiginiDogrular() {
        page.urlAssertion();
    }
}
