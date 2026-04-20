package stepDefinition;

import io.cucumber.java.en.*;
import utility.Pages;
import utility.Base;

public class AllCoursesSteps {

    @Given("user is on My Learning page")
    public void user_is_on_my_learning_page() {

        try {
            Thread.sleep(10000);
        } catch (Exception e) {}

        Base.driver.get("https://www.udemy.com/home/my-courses/");
    }
    
    @Then("user should see course {string} in All Courses page")
    public void user_should_see_course_in_all_courses_page(String courseName) {

        Pages.allCoursesPage.clickAllCourses(Base.driver);

        boolean result = Pages.allCoursesPage.isCoursePresent(Base.driver, courseName);

        if (!result) {
            throw new AssertionError("❌ Course NOT found: " + courseName);
        }
    }

    @Then("user should not see course {string} in All Courses page")
    public void user_should_not_see_course_in_all_courses_page(String courseName) {

        Pages.allCoursesPage.clickAllCourses(Base.driver);

        boolean result = Pages.allCoursesPage.isCoursePresent(Base.driver, courseName);

        if (result) {
            throw new AssertionError("❌ Course SHOULD NOT be present: " + courseName);
        }
    }
}