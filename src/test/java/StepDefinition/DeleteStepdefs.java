package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.WebElements;

import static StepDefinition.AddCusStepdefs.driver;

public class DeleteStepdefs {

    WebElements webElements;

    @Given("user in customers page")
    public void userInCustomersPage() throws InterruptedException {

        webElements = new WebElements(driver);
        Thread.sleep(2000);
        webElements.selectCustomerPage();

    }

    @When("user search names")
    public void userSearchNames() throws InterruptedException {

        Thread.sleep(2000);
        webElements.searchCus();

    }

    @And("delete the account")
    public void deleteTheAccount() throws InterruptedException {

        Thread.sleep(2000);
        webElements.deleteCus();

    }

    @Then("successfully account will be deleted")
    public void successfullyAccountWillBeDeleted() throws InterruptedException {

        Thread.sleep(2000);
        webElements.homeButton();
    }
}
