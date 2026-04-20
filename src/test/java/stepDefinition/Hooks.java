package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utility.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks extends Base {

    public static Properties prop;

    // Load config
    public void loadConfig() {

        prop = new Properties();

        try {
            String path = System.getProperty("user.dir")
                    + "/src/main/resources/CommonData/config.properties";

            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setup() {

        loadConfig();

        String browser = prop.getProperty("browser", "chrome");

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch URL
        driver.get(prop.getProperty("url"));

        System.out.println("✔ Browser launched");
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("✔ Browser closed");
    }
}