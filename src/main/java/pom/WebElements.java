package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebElements {
    public WebDriver driver;


    public WebElements(WebDriver driver){

        this.driver = driver;
    }



    //   First Scenario
    public void clickBankManagerLoginButton() {
        driver.findElement(By.xpath("//button[@ng-click=\"manager()\"]")).click();

    }
    public void clickAddAccountButton() {
        driver.findElement(By.xpath("//button[@ng-click=\"addCust()\"]")).click();

    }
    public void userEnterFirstNameAndLastNameAndPostCode(String firstName, String lastName, String postCode) {
        driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]")).sendKeys(postCode);

    }
    public void clickAddCustomerButton() {

        driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();

    }
    public void clickOk() {
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= alert.getText(); // capture alert message

        System.out.println(alertMessage);

        Assert.assertEquals(alertMessage,alertMessage );

        alert.accept();

    }


//    2nd Scenario

    public void opnAccount(){

        driver.findElement(By.xpath("//button[@ng-click='openAccount()']")).click();

    }

    public void selectName(){

        driver.findElement(By.xpath("//select[@name='userSelect']")).click();
        // driver.findElement(By.xpath("//option[@value='13']")).click();
        driver.findElement(By.xpath("//select//option[text()='Santo Masrur']")).click();

    }
    public void selectCurrency(){

        driver.findElement(By.xpath("//select[@id='currency']")).click();
        driver.findElement(By.xpath("//select//option[text()='Dollar']")).click();

    }
    public void selectButton(){

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }

    public void popUp() {
        Alert alert = driver.switchTo().alert(); // switch to alert

        String alertMessage= alert.getText(); // capture alert message

        System.out.println(alertMessage);

        alert.accept();

    }


//    3rd Scenario

    public void selectCustomerPage(){

        driver.findElement(By.xpath("//button[@ng-click=\"showCust()\"]")).click();


    }
    public void searchCus(){

        driver.findElement(By.xpath("//input[@placeholder=\"Search Customer\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"Search Customer\"]")).sendKeys("Santo");

    }

    public void deleteCus(){

        driver.findElement(By.xpath("//button[@ng-click=\"deleteCust(cust)\"]")).click();

    }

    public void homeButton(){

        driver.findElement(By.xpath("//button[@class=\"btn home\"]")).click();

    }







}
