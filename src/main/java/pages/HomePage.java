package pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageResources.GeneralResources;
import pageResources.HomePageResources;
import utility.PageFunctions;


public class HomePage extends PageFunctions {
    public HomePage(WebDriver driver) {
         super(driver);
    }
    SoftAssert softAssert = new SoftAssert();
    public void openHomePageURl () {
        driver.get(GeneralResources.homePageUrl.getResource());
    }

    public void clickHomeButton () {
        clickElement(HomePageResources.HomeButton.getResource());
    }
     public void checkAllHomePageElements () {
        checkIfAllElementsAreDisplayed(HomePageResources.getAllLocators(), softAssert);
     }





}
