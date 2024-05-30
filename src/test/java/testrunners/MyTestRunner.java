package testrunners;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.*;
import org.junit.runner.*;
import org.testng.annotations.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"})

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

public class MyTestRunner  {

}
