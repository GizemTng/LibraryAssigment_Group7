package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidLoginStepDef {

    LoginPage loginPage=new LoginPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);

    @Given("user is on the loginPage")
    public void user_is_on_the_login_page() {
        System.out.println("From Hooks Class");
    }
    @When("user enters invalid email address or password")
    public void user_enters_invalid_email_address_or_password() {
        loginPage.InputEmailAddress.sendKeys("student1@libray");
        loginPage.InputPassword.sendKeys("123");

    }
    @When("user click sign in button")
    public void user_click_sign_in_button() {
       loginPage.signInBtn.click();
    }
    @Then("verify the error message {string}")
    public void verify_the_error_message(String expectedMsg) {

        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMsg));

        Assert.assertEquals(expectedMsg,loginPage.errorMsg.getText());
    }
}
