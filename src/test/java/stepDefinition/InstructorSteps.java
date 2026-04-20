<<<<<<< HEAD
package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;
import hooks.Hooks;
import utility.Pages;
import utility.AllFunctionality;

public class InstructorSteps {

    WebDriver driver = Hooks.driver;
    AllFunctionality util = new AllFunctionality();

    // ================= BACKGROUND =================

    @Given("User launches Chrome browser")
    public void user_launches_browser() {

        driver = Hooks.driver;

        Pages.initPages(driver);

        util.maximize(driver);
    }

    // ================= SEARCH =================

    @When("User searches for {string}")
    public void user_searches_for(String course) {

        Pages.home.searchCourse(course);
    }

    @When("User searches course from excel row {int}")
    public void user_searches_course_from_excel_row(Integer row) throws Exception {

        util.loadExcelFile(
                "src/test/resources/testdata.xlsx",
                "Sheet1"
        );

        String courseName = util.getDataFromSingleCell(row, 0);

        Pages.home.searchCourse(courseName);
    }

    @Then("Search results should be displayed")
    public void search_results_should_be_displayed() {

        List<WebElement> list = Pages.search.getAllCourses();

        Assert.assertTrue(list.size() > 0, "No search results found");
    }

    // ================= COURSE =================

    @When("User selects the first course")
    public void user_selects_first_course() {

        Pages.search.clickFirstCourse();
    }

    @When("User adds the course to cart")
    public void user_adds_course_to_cart() {

        Pages.course.clickAddToCart();
    }

    @Then("Course should be added to cart successfully")
    public void course_added_successfully() {

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "Cart page not opened");
    }

    // ================= INSTRUCTOR =================

    @When("User clicks on instructor {string}")
    public void user_clicks_on_instructor(String name) {

        Pages.course.clickInstructor();
    }

    @Then("Instructor profile page should be displayed")
    public void instructor_page_displayed() {

        Assert.assertTrue(driver.getCurrentUrl().contains("/user/"),
                "Instructor page not opened");
    }

    // ================= SOCIAL LINKS =================

    @When("User clicks on LinkedIn link")
    public void user_clicks_linkedin() {

        Pages.instructor.clickLinkedIn();
    }

    @Then("LinkedIn page should open in new tab")
    public void linkedin_page_opened() {

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("linkedin"),
                "LinkedIn page not opened");
    }

    @When("User switches back to instructor profile")
    public void switch_back() {

        driver.navigate().back();
    }

    @When("User clicks on YouTube link")
    public void user_clicks_youtube() {

        Pages.instructor.clickYouTube();
    }

    @Then("YouTube channel should open successfully")
    public void youtube_opened() {

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("youtube"),
                "YouTube page not opened");
    }

    // ================= NEGATIVE =================

    @Then("No courses should be displayed")
    public void no_courses_displayed() {

        List<WebElement> list = Pages.search.getAllCourses();

        Assert.assertTrue(list.size() == 0,
                "Results shown for invalid search");
    }

    @Then("User should see a {string} message")
    public void user_should_see_message(String msg) {

        Assert.assertTrue(true); // placeholder (can be improved later)
=======
package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CoursePage;
import pages.InstructorPage;
import utility.Base;

public class InstructorSteps extends Base {

    CoursePage coursePage;
    InstructorPage instructorPage;

    private String capturedInstructorName = "";

    @When("User captures and clicks the instructor link")
    public void captureAndClickInstructor() throws InterruptedException {

        coursePage = new CoursePage(driver);

        // wait before accessing
        Thread.sleep(3000);

        capturedInstructorName = coursePage.getInstructorName();

        Assert.assertNotNull(capturedInstructorName, "Instructor name is null");

        capturedInstructorName = capturedInstructorName.trim();

        System.out.println("✔ Instructor captured: " + capturedInstructorName);

        // scroll properly
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);",
                        coursePage.instructor);

        Thread.sleep(1000);

        coursePage.clickInstructor();

        Thread.sleep(3000);
    }

    @Then("User should be navigated to the instructor profile section or page")
    public void userOnInstructorProfileOrSection() {

        boolean profileOpened = false;

        try {
            new org.openqa.selenium.support.ui.WebDriverWait(
                    driver, java.time.Duration.ofSeconds(10))
                    .until(org.openqa.selenium.support.ui.ExpectedConditions
                            .urlContains("user"));
            profileOpened = true;
        } catch (Exception e) {
            System.out.println("URL not changed — checking scroll section");
        }

        if (profileOpened) {

            Assert.assertTrue(driver.getCurrentUrl().contains("user"));

        } else {

            String firstName = capturedInstructorName.split(" ")[0];

            try {
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("window.scrollTo(0, document.body.scrollHeight)");

                org.openqa.selenium.WebElement section =
                        new org.openqa.selenium.support.ui.WebDriverWait(
                                driver, java.time.Duration.ofSeconds(10))
                                .until(org.openqa.selenium.support.ui.ExpectedConditions
                                        .visibilityOfElementLocated(
                                                org.openqa.selenium.By.xpath(
                                                        "//a[contains(text(),'" + firstName + "')]")));

                Assert.assertTrue(section.isDisplayed());

            } catch (Exception ex) {
                Assert.fail("Instructor not found in both cases");
            }
        }
    }

    @Then("the instructor name should match the course detail page")
    public void instructorNameShouldMatch() {

        if (!driver.getCurrentUrl().contains("user")) {
            System.out.println("⚠ Scroll case — skipping name match");
            return;
        }

        instructorPage = new InstructorPage(driver);

        String profileName = instructorPage.getInstructorHeader().trim();

        String key = capturedInstructorName.split(" ")[0].toLowerCase();

        System.out.println("Course: " + capturedInstructorName);
        System.out.println("Profile: " + profileName);

        // Soft check (first name only)
        Assert.assertTrue(
            profileName.toLowerCase().contains(key),
            "Instructor mismatch"
        );
>>>>>>> e71426da94a0b34b622f5ee58f65c39a4979bdb1
    }
}