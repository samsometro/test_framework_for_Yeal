package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class DriverFactory {

    public static void setUpDriver() {
        SuiteConfiguration suiteConfiguration = new SuiteConfiguration();

        Configuration.baseUrl = suiteConfiguration.getProperty("baseUrl");
        Configuration.browserSize = "1920x1080";

        String headless = suiteConfiguration.getProperty("headless");
        String selenoid = suiteConfiguration.getProperty("selenoid");

        if (headless.equalsIgnoreCase("true")) {
            Configuration.headless = true;
        }

        if (selenoid.contains("/wd/hub")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("browserVersion", suiteConfiguration.getProperty("browserVersion"));
            desiredCapabilities.setCapability("browserName", suiteConfiguration.getProperty("browser"));
            desiredCapabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
                put("enableVideo", false);
                put("enableVNC", false);
            }});
            Configuration.remote = selenoid;
            Configuration.browserCapabilities = desiredCapabilities;
        }
    }
}
