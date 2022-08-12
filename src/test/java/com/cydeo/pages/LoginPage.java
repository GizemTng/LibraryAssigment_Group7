package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public void login(){
        String username= ConfigurationReader.getProperty("librarian_username");
        String password=ConfigurationReader.getProperty("password");

        InputEmailAddress.sendKeys(username);
        InputPassword.sendKeys(password);
        signInBtn.click();

    }


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement InputEmailAddress;

    @FindBy(id = "inputPassword")
    public   WebElement  InputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public   WebElement signInBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement errorMsg;





}
