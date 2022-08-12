package com.cydeo.step_definitions;

import com.cydeo.pages.BasePageForLibrarian;
import com.cydeo.pages.BookManagementPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingNewBookStepDef {

    BasePageForLibrarian basePageForLibrarian=new BasePageForLibrarian();
    BookManagementPage bookManagementPage=new BookManagementPage();
    Faker faker=new Faker();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);



    @When("librarian click Books module")
    public void librarian_click_books_module() {
      basePageForLibrarian.booksLink.click();
    }
    @When("librarian click \"+Add Book” button")
    public void librarian_click_add_book_button() {
       bookManagementPage.addBook.click();
    }
    @When("librarian enter BookName, ISBN, Year, Author, and Description")
    public void librarian_enter_book_name_isbn_year_author_and_description() {
      bookManagementPage.nameBox.sendKeys(faker.name().name());
      bookManagementPage.isbnBox.sendKeys(faker.number().digits(4));
      bookManagementPage.year.sendKeys(faker.number().digits(4));
      bookManagementPage.author.sendKeys(faker.name().fullName());
      bookManagementPage.description.sendKeys(faker.letterify("Random description").toLowerCase());
    }
    @Then("verify a new book is added")
    public void verify_a_new_book_is_added() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='toast-message']")));

        String expectedMsg = "The book has been created.";
        String actualMsg = bookManagementPage.newBookAddedMsg.getText();

        Assert.assertEquals("Message is not verified!", expectedMsg, actualMsg);
    }

}
