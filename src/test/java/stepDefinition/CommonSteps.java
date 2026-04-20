package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utility.Pages;

public class CommonSteps {
	CommonSteps page;
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	public static String expectedURL;
	public CommonSteps(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
	}

	    @Given("User navigates to {string}")
	    public void user_navigates_to(String url) {
	        driver.get(url);
	    }

	    @When("User clicks on Explore menu")
	    public void user_clicks_on_explore_menu() {
	    	Pages.common.clickExplore();
	    }

	    @When("User chooses {string}")
	    public void user_chooses(String category) throws InterruptedException {
	    	Pages.common.selectCategory(category);
	    }

	    @When("User selects subcategory {string}")
	    public void user_selects_subcategory(String subCategory) throws InterruptedException {
	    	Pages.common.selectSubCategory(subCategory);
	    }
	    
	    @When("User clicks on the first available course")
	    public void user_clicks_on_the_first_available_course() {
	    	expectedURL = Pages.common.clickFirstCourse();
	    }

}
