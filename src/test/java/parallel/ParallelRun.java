package parallel;


import io.cucumber.junit.*;
import io.cucumber.testng.*;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.*;
import org.testng.annotations.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel/LoginPage.feature"},
        glue = {"parallel"},
        //tags = "not @Skip",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:target/failedrerun.txt"},
        monochrome = true)

public class ParallelRun extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
