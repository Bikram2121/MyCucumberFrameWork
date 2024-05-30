package com.qa.factory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     *
     * @param browser
     * @return
     */

    public WebDriver init_driver(String browser) {
        System.out.println("browser value is : " + browser);
        if (browser.equals("edge")) {
            tlDriver.set(new EdgeDriver());
        } else if (browser.equals("firefox")) {
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("chrome")) {
            tlDriver.set(new ChromeDriver());
        } else {
            System.out.println("Pass the correct browser value : " + browser);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();

    }

    /**
     * This is used to get the driver with ThreadLocal
     *
     * @return
     */
    public synchronized static WebDriver getDriver() {
        return tlDriver.get();
    }


}
