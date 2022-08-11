package com.cydeo.step_definitions;

import com.cydeo.pages.BasePageForStudent;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StudentLoginStepDef {
    LoginPage loginPage=new LoginPage();
    BasePageForStudent basePageForStudent=new BasePageForStudent();

    @Given("student is on the loginPage")
    public void student_is_on_the_login_page() {
        System.out.println("Coming from the Hooks Class");
    }
    @Then("verify that the URL is {string}")
    public void verify_that_the_url_is(String expectedUrl) {
        Assert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
    }

    @When("student enters valid {string} and {string}")
    public void studentEntersValidAnd(String studentEmail, String studentPassword) {
        loginPage.InputEmailAddress.sendKeys(studentEmail);
        loginPage.InputPassword.sendKeys(studentPassword);
    }


    @When("student click sign in button")
    public void student_click_sign_in_button() {
       loginPage.signInBtn.click();
    }
    @Then("verify that there are two models on the page")
    public void verify_that_there_are_two_models_on_the_page() {
Assert.assertTrue(basePageForStudent.booksLink.isDisplayed());

Assert.assertTrue(basePageForStudent.borrowingBookLink.isDisplayed());

    }



}
