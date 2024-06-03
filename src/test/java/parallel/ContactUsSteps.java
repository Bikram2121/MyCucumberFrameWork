package parallel;

import com.pages.*;
import com.qa.factory.*;
import com.qa.utils.*;
import io.cucumber.java.en.*;
import org.apache.poi.openxml4j.exceptions.*;
import org.testng.Assert;

import java.io.*;
import java.util.*;

public class ContactUsSteps {

    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("User is navigates to contact us page")
    public void user_is_navigates_to_contact_us_page() {
        DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=contact");
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {
        ExcelReader reader = new ExcelReader();
        try {
            List<Map<String, String>> testData = reader.getData("src/test/resources/exceltestdata/automationdata.xlsx", sheetName);
            String heading = testData.get(rowNumber).get("Subject Heading");
            String emailId = testData.get(rowNumber).get("Email address");
            String orderRef = testData.get(rowNumber).get("Order reference");
            String message = testData.get(rowNumber).get("Message");

            contactUsPage.fillContactUsForm(heading, emailId, orderRef, message);

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        contactUsPage.clickSend();
    }

    @Then("it shows successful message {string}")
    public void it_shows_successful_message(String expSuccessMsg) throws InterruptedException {
        String actSuccessMsg = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actSuccessMsg, expSuccessMsg);
    }

}
