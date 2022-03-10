package utility;

import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class AllureEnvironmentSetup {
   private static final Properties properties = new Properties();
   private static final ChromeOptions options = new ChromeOptions();

    public static String browserName() {
       return options.getBrowserName();
    }
    public static String browserVersion() {
        return options.getBrowserVersion();
    }
    public static String operatingSystem () {
        return System.getProperty("os.name");
    }
    public static void main() {

        try (OutputStream outputStream = new FileOutputStream("target/allure-results/environment.properties")) {
          properties.setProperty("Browser", browserName());
          properties.setProperty("Browser Version", browserVersion());
          properties.setProperty("Operating System", operatingSystem());

          properties.store(outputStream, null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
