package com.pages;

import org.openqa.selenium.*;

import java.util.*;

public class AccountsPage {

    private final WebDriver driver;

    private final By accountSections = By.cssSelector("div.row.addresses-lists span");


    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public List<String> getAccountsSectionsList() {
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountHeaderList = driver.findElements(accountSections);
        for (WebElement e : accountHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }
        return accountsList;
    }
}
