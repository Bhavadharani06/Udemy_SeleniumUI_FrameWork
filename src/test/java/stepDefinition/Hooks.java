package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utility.Base;

public class Hooks extends Base {

    @Before
    public void setup() {

        // Initialize driver (reads browser from config)
        initializeDriver();

        // Launch application (reads URL from config)
        launchApp();

        System.out.println("Browser launched");
    }

    @After
    public void tearDown() {

        System.out.println("Closing Browser");

        if (driver != null) {
            driver.quit();
        }
    }
}