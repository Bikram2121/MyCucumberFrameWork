package parallel;

import com.pages.*;
import com.qa.factory.*;
import io.cucumber.datatable.*;
import io.cucumber.java.en.*;
import org.junit.*;

import java.util.*;

public class AccountsPageSteps {
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged into the application")
    public void user_has_already_logged_into_the_application(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(userName, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
      String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts page title: " + title);
    }

    @Then("user gets account section")
    public void user_gets_account_section(DataTable sectionsTable) {
        List<String> expAccountSecList = sectionsTable.asList();
        System.out.println("Expected accounts section list is : " +expAccountSecList);
       List<String> actAccountsSecList = accountsPage.getAccountsSectionsList();
        System.out.println("Actual accounts section list is : " +actAccountsSecList);
        Assert.assertEquals(actAccountsSecList, expAccountSecList);
    }

    @Then("Account section count is {int}")
    public void account_section_count_is(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
    }

}
