package stepDefinition;

import io.cucumber.java.en.*;
import utility.Pages;

import utility.Base;

public class ArchiveSteps {

    @Given("User is on My Learning page")
    public void user_is_on_my_learning_page() {
    	try {
    		Thread.sleep(10000);
    	}
    	catch(Exception e){
    	}
        Base.driver.get("https://www.udemy.com/home/my-courses/");
    }

    @When("User navigates to Archived tab")
    public void user_navigates_to_archived_tab() {
        Pages.archivePage.clickArchivedTab();
    }

    @Then("User handles archive based on availability")
    public void user_handles_archive_based_on_availability() {
        Pages.archivePage.handleArchiveFlow();
    }
}