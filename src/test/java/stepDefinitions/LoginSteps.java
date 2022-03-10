package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utility.BrowserDriverFactory;

public class LoginSteps {
    LoginPage loginPage;
    HomePage homePage;

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(BrowserDriverFactory.getDriver());
        loginPage.loginGetUrl();
    }

    @And("The user enters {string} and {string}")
    public void theUserEntersAnd(String MailText, String PassText) {
        loginPage.enterCredentials(MailText, PassText);
    }

    @When("The user clicks submit button")
    public void the_user_clicks_submit_button() {
        loginPage.clickLogin();
    }

    @Then("The user should be logged in")
    public void theUserShouldBeLoggedIn() {
        loginPage.checkLoginUrl();
    }


    @When("The user click on the Home button")
    public void theUserClickOnTheHomeButton() {
        loginPage.clickHomeButton();

    }

    @Then("The user should be redirected to the Home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        homePage = loginPage.checkHomePageRedirection();

    }
}
