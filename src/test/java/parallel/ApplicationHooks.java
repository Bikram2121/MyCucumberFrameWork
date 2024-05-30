package parallel;

import com.qa.factory.*;
import com.qa.utils.*;
import io.cucumber.java.*;
import org.openqa.selenium.*;

import java.util.*;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }


    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //take screenshot:
            String screenShotName = scenario.getName().replaceAll(" ", "_");
            byte[] srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcPath, "image/png", screenShotName);

        }
    }


}
