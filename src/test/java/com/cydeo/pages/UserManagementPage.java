package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementPage extends BasePageForLibrarian {

    @FindBy(xpath ="//a[.=' Add User']")
    public WebElement addUser;

    @FindBy (xpath = "//input[@name='full_name']")
    public WebElement fullNameBox;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy (xpath ="//input[@name='email']" )
    public WebElement emailBox;

    @FindBy (id = "address")
    public WebElement addressBox;

    @FindBy (xpath ="//button[.='Save changes']" )
    public WebElement saveChanges;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement userHasBeenAddedMsg;

}
