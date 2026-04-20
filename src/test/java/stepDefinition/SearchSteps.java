package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;
import utility.AllFunctionality;
import utility.Base;

public class SearchSteps extends Base {

    AllFunctionality util = new AllFunctionality();

    HomePage homePage;
    SearchPage searchPage;

    public static String searchKeyword;
    public static String capturedCourseATitle;

    @Given("User is on the Udemy homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);

        Assert.assertFalse(
                driver.getCurrentUrl().contains("challenge"),
                "Captcha not cleared"
        );

        System.out.println("On homepage");
    }

    @When("User searches for the course using test data")
    public void userSearchesUsingTestData() throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/testdata/TestData.xlsx";

        util.loadExcelFile(path, "Sheet1"); 

        searchKeyword = util.getDataFromSingleCell(1, 1);

        homePage = new HomePage(driver);
        homePage.searchCourse(searchKeyword);

        Thread.sleep(5000); // keep for now

        System.out.println("✔ Searched: " + searchKeyword);
    }

    @Then("the search results page should display relevant courses")
    public void searchResultsShouldDisplayCourses() {

        searchPage = new SearchPage(driver);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {}

        Assert.assertTrue(searchPage.courses.size() > 0, "No courses found");

        System.out.println("✔ Results loaded: " + searchPage.courses.size());
    }

    @Then("the search results page should display at least 2 courses")
    public void searchResultsAtLeastTwoCourses() {

        searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.courses.size() >= 2,
                "Less than 2 courses found"
        );
    }

    @When("User clicks the first course link and switches to new tab if opened")
    public void clickFirstCourseSwitchTab() throws InterruptedException {
        searchPage = new SearchPage(driver);
        searchPage.openFirstCourse();
    }

    @When("User clicks the first course link and captures its title")
    public void clickFirstCourseCaptureTitle() throws InterruptedException {

        searchPage = new SearchPage(driver);

        capturedCourseATitle = searchPage.getCourseTitle(0);

        searchPage.openFirstCourse();
    }

    @When("User clicks the first course link")
    public void clickFirstCourseLink() throws InterruptedException {
        searchPage = new SearchPage(driver);
        searchPage.openFirstCourse();
    }
}