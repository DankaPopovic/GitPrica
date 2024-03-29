package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserDriverFactory {


    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                tlDriver.set(new SafariDriver());
                break;
            case "headless":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "window-size=1920,1080");
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver(options));
                break;
            default:
                System.out.println("Please pass the correct browser value: " + browser);
                break;
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }



    }
