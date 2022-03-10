package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utility.BrowserDriverFactory;

public class HomeSteps {

    HomePage homePage;

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        homePage = new HomePage(BrowserDriverFactory.getDriver());
        homePage.openHomePageURl();
    }
    @When("The user navigates to the Home button")
    public void theUserClickOnTheHomeButton() {
        homePage.clickHomeButton();
    }
    @Then("All elements should be present")
    public void hotel_rooms_should_be_shown() {
        homePage.checkAllHomePageElements();
    }


}
