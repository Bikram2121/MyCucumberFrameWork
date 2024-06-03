package com.pages;

import org.openqa.selenium.*;

public class LoginPage {

    private WebDriver driver;
    //By locators:
    private By emailID = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPasswordLink = By.linkText("Forgot your password?");

    //Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Page actions: features(behavior) of the page in the form of methods

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkPresent() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailID).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }

    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with : " + un + "and pwd : " + pwd);
        driver.findElement(emailID).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }


}
