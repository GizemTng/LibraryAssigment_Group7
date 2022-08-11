package com.cydeo.step_definitions;

import com.cydeo.pages.BasePageForLibrarian;
import com.cydeo.pages.LoginPage;
import com.cydeo.pages.UserManagementPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingNewUserStepDef {

    UserManagementPage userManagementPage=new UserManagementPage();
    BasePageForLibrarian basePageForLibrarian=new BasePageForLibrarian();
    LoginPage loginPage=new LoginPage();
    Faker faker=new Faker();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);

    @Given("librarian is on the homePage")
    public void librarian_is_on_the_home_page() {
        loginPage.InputEmailAddress.sendKeys("librarian1@library");
        loginPage.InputPassword.sendKeys("qU9mrvur");
        loginPage.signInBtn.click();

    }
    @When("librarian click Users module")
    public void librarian_click_users_module() {
      basePageForLibrarian.usersLink.click();
    }

    @When("librarian click “+Add User” button")
    public void librarian_click_add_user_button() {
        userManagementPage.addUser.click();
    }
    @When("librarian enter full name, password, email and address")
    public void librarian_enter_full_name_password_email_and_address() {
       userManagementPage.fullNameBox.sendKeys(faker.name().fullName());
       userManagementPage.passwordBox.sendKeys(faker.number().digit());
       userManagementPage.emailBox.sendKeys(faker.internet().emailAddress());
       userManagementPage.addressBox.sendKeys(faker.address().fullAddress());
    }
    @When("librarian click save changes")
    public void librarian_click_save_changes() {
        userManagementPage.saveChanges.click();
    }
    @Then("verify a new user is created")
    public void verify_a_new_user_is_created() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='toast-message']")));

        String expectedMsg = "The user has been created.";
        String actualMsg = userManagementPage.userHasBeenAddedMsg.getText();

        Assert.assertEquals("Message is not verified!", expectedMsg, actualMsg);

    }







}
