package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.*;

public class Hooks extends AllFunctionality {

	@Before
	public void setUp() throws IOException {

	    String URL = getPropertyKeyValue("url");

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-blink-features=AutomationControlled");

	    Base.driver = new ChromeDriver(options);

	    maximize(Base.driver);
	    implicitWait(Base.driver, 30);

	    Base.driver.get(URL);

	    waitForCaptchaIfPresent(Base.driver);

	    Pages.loadAllPages(Base.driver);

	    System.out.println("✅ Browser launched");
	}

	@After
	public void tearDown() {

//        if (driver != null) {
//            driver.quit();
//        }

		System.out.println("❌ Browser closed");
	}
	
}
