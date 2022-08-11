package com.cydeo.step_definitions;

import com.cydeo.pages.BasePageForLibrarian;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LibrarianLoginStepDef {
    LoginPage loginPage = new LoginPage();
    BasePageForLibrarian basePageForLibrarian = new BasePageForLibrarian();


    @Given("librarian is on the loginPage")
    public void librarian_is_on_the_login_page() {
        System.out.println("Coming from hooks");
    }

    @Then("verify that the title is {string}")
    public void verify_that_the_title_is(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    @When("librarian enters valid {string} address and {string}")
    public void librarianEntersValidAddressAnd(String librarianEmail, String librarianPassword) {

        loginPage.InputEmailAddress.sendKeys(librarianEmail);
        loginPage.InputPassword.sendKeys(librarianPassword);
    }

    @When("librarian click sign in button")
    public void librarian_click_sign_in_button() {
        loginPage.signInBtn.click();
    }

    @Then("verify that there are three models on the page")
    public void verify_that_there_are_three_models_on_the_page() {

        Assert.assertTrue(basePageForLibrarian.dashboardLink.isDisplayed());

        Assert.assertTrue(basePageForLibrarian.booksLink.isDisplayed());

        Assert.assertTrue(basePageForLibrarian.usersLink.isDisplayed());


    }


}
