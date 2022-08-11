package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookManagementPage extends BasePageForLibrarian{


    @FindBy(xpath ="//button[.='Save changes']" )
    public WebElement saveChanges;

    @FindBy(xpath = "//a[.=' Add Book']")
    public WebElement addBook;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement isbnBox;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement year;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement author;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement newBookAddedMsg;








}
