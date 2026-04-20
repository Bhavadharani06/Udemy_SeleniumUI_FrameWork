package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class AllCoursesPage {
    // LOCATORS 

    @FindBy(xpath = "//a[contains(.,'All courses')]")
    private WebElement allCoursesTab;

    // GETTERS

    public WebElement getAllCoursesTab() {
        return allCoursesTab;
    }

    // ACTION METHODS

    public void clickAllCourses(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(allCoursesTab)).click();
    }

    // DYNAMIC LOCATOR 

    public List<WebElement> getCourseList(WebDriver driver, String courseName) {

        String xpath = "//h3[contains(text(),'" + courseName + "')]";

        return driver.findElements(By.xpath(xpath));
    }

    // ASSERTION METHOD

    public boolean isCoursePresent(WebDriver driver, String courseName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class,'course-card')]")
            ));

            List<WebElement> courses = getCourseList(driver, courseName);

            return courses.size() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    // BUSINESS METHOD

    public void verifyCoursePresent(WebDriver driver, String courseName) {

        boolean result = isCoursePresent(driver, courseName);

        if (result) {
            System.out.println("Course FOUND: " + courseName);
        } else {
            throw new AssertionError("Course NOT FOUND: " + courseName);
        }
    }
}