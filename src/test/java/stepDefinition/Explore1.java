package stepDefinition;

import io.cucumber.java.en.Then;

public class Explore1 {
	String expectedURL;

    @Then("Courses should be displayed")
    public void courses_should_be_displayed() {
        if (!Hooks.page1.isCoursesDisplayed()) {
            throw new RuntimeException(" Courses are NOT displayed");
        } else {
            System.out.println(" Courses are displayed");
        }
    }
//
//    @When("User clicks on the first available course")
//    public void user_clicks_on_the_first_available_course() throws InterruptedException {
//        expectedURL = UdemyHook.page1.clickFirstCourse();;
//    }

    @Then("The course page URL should match the selected course URL")
    public void the_course_page_url_should_match_the_selected_course_url() {

        String parentWindow = UdemyHook.driver.getWindowHandle();

        for (String window : UdemyHook.driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                UdemyHook.driver.switchTo().window(window);
                break;
            }
        }

        String actualURL = UdemyHook.driver.getCurrentUrl();

        String expectedPath = CommonSteps.expectedURL.split("\\?")[0];
        String actualPath = actualURL.split("\\?")[0];

        if (actualPath.equals(expectedPath)) {
            System.out.println("PASS");
            System.out.println("Expected: " + expectedPath);
            System.out.println("Actual: " + actualPath);
        } else {
            System.out.println("FAIL");
            System.out.println("Expected: " + expectedPath);
            System.out.println("Actual: " + actualPath);
        }
    }

}
