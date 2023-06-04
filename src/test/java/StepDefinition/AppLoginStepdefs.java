package StepDefinition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppLoginStepdefs {

    DesiredCapabilities dc = new DesiredCapabilities();
    AndroidDriver driver = null;


    @Given("User in the login page")
    public void userInTheLoginPage() throws InterruptedException, MalformedURLException {

        dc.setCapability(MobileCapabilityType.UDID, "09cebb1a");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 7");
        dc.setCapability("platformVersion", "12.0");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        Thread.sleep(7000);
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

    }

    @And("User fill {string} and {string}")
    public void userFillUserNameAndPassword(String userName, String password) throws InterruptedException {

        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@text='Username']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys(userName);
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(password);

    }

    @And("press login button")
    public void pressLoginButton() throws InterruptedException {

        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@text='Login']")).click();

    }

    @Then("user will be logged in")
    public void userWillBeLoggedIn() {

        System.out.println("**********************");
    }
}
