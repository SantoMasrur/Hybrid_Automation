package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.WebElements;

import static StepDefinition.AddCusStepdefs.driver;

public class OpenAccountStepdefs {

    WebElements webElements;

    @Given("User in open account page")
    public void userInOpenAccountPage() throws InterruptedException {

        webElements = new WebElements(driver);
        Thread.sleep(2000);
        webElements.opnAccount();

    }

    @When("user select name from dropdown menu")
    public void userSelectNameFromDropdownMenu() throws InterruptedException {

        Thread.sleep(2000);
        webElements.selectName();

    }

    @And("select currency from dropdown menu")
    public void selectCurrencyFromDropdownMenu() throws InterruptedException {

        Thread.sleep(2000);
        webElements.selectCurrency();

    }

    @And("click process button")
    public void clickProcessButton() throws InterruptedException {

        Thread.sleep(2000);
        webElements.selectButton();

    }

    @Then("user successfully navigate the popup")
    public void userSuccessfullyNavigateThePopup() throws InterruptedException {

        Thread.sleep(2000);
        webElements.popUp();




    }
}
