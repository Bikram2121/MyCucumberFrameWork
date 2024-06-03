package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ContactUsPage {
    private WebDriver driver;

    private By subjectHeading = By.id("id_contact");
    private By emailAddress = By.id("email");
    private By orderReference = By.id("id_order");
    private By messageText = By.id("message");

    private By sendButton = By.id("submitMessage");
    private By successMsg = By.cssSelector("div#center_column p");


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getContactUsPageTitle() {
        return driver.getTitle();
    }

    public void fillContactUsForm(String heading, String emailId, String orderRef, String message) {
        Select select = new Select(driver.findElement(subjectHeading));
        select.selectByVisibleText(heading);
        driver.findElement(emailAddress).sendKeys(emailId);
        driver.findElement(orderReference).sendKeys(orderRef);
        driver.findElement(messageText).sendKeys(message);
    }

    public void clickSend() {
        driver.findElement(sendButton).click();
    }

    public String getSuccessMessage() throws InterruptedException {
        return driver.findElement(successMsg).getText();
    }


}
