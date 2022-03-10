package stepDefinitions;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageResources.GeneralResources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utility.BrowserDriverFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AppHooks {
    private WebDriver driver;

    @Before
    public void launchBrowser() {
        BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory();
        driver = browserDriverFactory.init_driver(GeneralResources.browserName.getResource());

    }
    @After(order = 1)
    public void quitBrowser(){

        driver.quit();
    }
    @After(order = 2)

        public void getScreenshotAllure(Scenario scenario) throws InterruptedException, IOException, IllegalMonitorStateException
        {
            if(scenario.isFailed())
            {
                Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            }
        }


}

