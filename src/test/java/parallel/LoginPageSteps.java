package parallel;

import com.pages.*;
import com.qa.factory.*;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginPageSteps {
    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @Then("forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkPresent());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Login page title: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @When("user clicks on Login button")
    public void user_Clicks_On_Login_Button() {
        loginPage.clickOnSignInButton();
    }
}
