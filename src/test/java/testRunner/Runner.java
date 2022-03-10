package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import utility.AllureReportingUtils;
import java.io.IOException;

@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/features/",
        glue = {"stepDefinitions"},
        monochrome = true
)
//allure generate C:/Users/njakovljevic/IdeaProjects/PersonalSeleniumProject/target/allure-results -o C:/Users/njakovljevic/IdeaProjects/basicdemoproject-master/target/allure-report --clean

public class Runner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void generateAllureReport () throws IOException, InterruptedException {
        AllureReportingUtils.main();

    }
}
