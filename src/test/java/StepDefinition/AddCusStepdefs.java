package StepDefinition;

import core.WebHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.WebElements;

public class AddCusStepdefs {


    public static WebDriver driver;

    WebElements webElements;


    @Given("user has base url")
    public void userHasBaseUrl() {

        WebHelper webHelper = new WebHelper();
        driver = webHelper.browser();

    }

    @When("click bank manager login button")
    public void clickBankManagerLoginButton() throws InterruptedException {

        webElements = new WebElements(driver);
        Thread.sleep(2000);
        webElements.clickBankManagerLoginButton();

    }

    @And("click add account button")
    public void clickAddAccountButton() throws InterruptedException {

        Thread.sleep(2000);
        webElements.clickAddAccountButton();

    }

    @And("user enter {string} and {string} and {string}")
    public void userEnterFirstNameAndLastNameAndPostCode(String firstName, String lastName, String postCode) throws InterruptedException {

        Thread.sleep(2000);
        webElements.userEnterFirstNameAndLastNameAndPostCode(firstName, lastName, postCode);

    }

    @And("click addCustomer button")
    public void clickAddCustomerButton() throws InterruptedException {

        Thread.sleep(2000);
        webElements.clickAddCustomerButton();


    }

    @Then("click ok")
    public void clickOk() throws InterruptedException {

        Thread.sleep(2000);
        webElements.clickOk();
    }
}
