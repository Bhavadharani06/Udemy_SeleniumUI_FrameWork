package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.*;

public class Hooks extends AllFunctionality {
	 public static WebDriver driver;

	 @Before
	 public void setup() throws Exception {

	     ChromeOptions options = new ChromeOptions();
	     options.addArguments("--disable-blink-features=AutomationControlled");
	     options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

	     driver = new ChromeDriver(options);
	     driver.manage().window().maximize();

	     // 👉 ADD THIS
	     String url = getPropertyKeyValue("url");
	     driver.get(url);

	     Pages.initPages(driver);
	 }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }
}
