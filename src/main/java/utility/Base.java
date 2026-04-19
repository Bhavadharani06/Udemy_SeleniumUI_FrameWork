package utility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    public static WebDriver driver;
    public static Properties prop;

    // ================= LOAD CONFIG =================
    public static void loadConfig() {

        prop = new Properties();

        try {
            String path = System.getProperty("user.dir")
                    + "/src/main/resources/CommonData/config.properties";

            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);

            System.out.println("✔ Config loaded from: " + path);

        } catch (Exception e) {
            System.out.println("❌ Failed to load config file");
            e.printStackTrace();
        }
    }

    // ================= INITIALIZE DRIVER =================
    public static WebDriver initializeDriver() {

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

        System.out.println("✔ Browser launched: " + browser);

        return driver;
    }

    // ================= LAUNCH APP =================
    public static void launchApp() {

        String url = prop.getProperty("url");

        if (url == null || url.isEmpty()) {
            throw new RuntimeException("❌ URL is missing in config.properties");
        }

        driver.get(url);
        System.out.println("✔ Opened URL: " + url);
    }

    // ================= GET PROPERTY =================
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    // ================= QUIT DRIVER =================
    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            System.out.println("✔ Browser closed");
        }
    }
}