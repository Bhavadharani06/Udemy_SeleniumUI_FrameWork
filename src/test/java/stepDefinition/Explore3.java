package stepDefinition;

import utility.Base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Pages;

public class Explore3  extends Base{
	

//	    // Constructor
//	    public Explore3() {
//	        page = new Explore3Page(Base.driver);
//	    }

	    // FILTER STEPS

	    @When("User chooses {string} category")
	    public void user_chooses_category(String category) throws InterruptedException {
	    	Pages.page1.selectCategory(category);
	    	Pages.page1.scrollToFilters();
	    }

	    @When("User selects sort option")
	    public void user_selects_sort_option() {
	    	Pages.page1.selectSortOption();
	    }

	    @When("User filters courses with rating")
	    public void user_filters_courses_with_rating() {
	    	Pages.page1.selectRating();
	    }

	    @When("User selects video duration")
	    public void user_selects_video_duration() {
	    	Pages.page1.selectVideoDuration();
	    }

	    @When("User selects topic")
	    public void user_selects_topic() {
	    	Pages.page1.selectTopic();
	    }

	    @When("User selects subcategory filter")
	    public void user_selects_subcategory_filter() {
	    	Pages.page1.selectSubCategoryFilter();
	    }

	    @When("User selects level")
	    public void user_selects_level() {
	    	Pages.page1.selectLevel();
	    }

	    @When("User selects language")
	    public void user_selects_language() {
	    	Pages.page1.selectLanguage();
	    }

	    @When("User selects price")
	    public void user_selects_price() {
	    	Pages.page1.selectPrice();
	    }

	    // VALIDATION
//
//	    @Then("Filtered courses should be displayed")
//	    public void filtered_courses_should_be_displayed() {
//	    	Pages.page1.isCoursesDisplayed();
//	    }
	    
	    @Then("Filtered courses should be displayed")
	    public void filtered_courses_should_be_displayed() {

	        boolean result = Pages.page1.isCoursesDisplayed();

	        if (!result) {
	            throw new RuntimeException("Filtered courses are NOT displayed");
	        }

	        System.out.println("Filtered courses are displayed");
	    }


}
