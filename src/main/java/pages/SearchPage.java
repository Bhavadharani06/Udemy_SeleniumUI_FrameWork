package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/course/')]")
    public List<WebElement> courses;

    public void openFirstCourse() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String parent = driver.getWindowHandle();

        WebElement course = courses.get(0);

        
        js.executeScript("arguments[0].scrollIntoView(true);", course);
        Thread.sleep(1000);

        course.click();
        Thread.sleep(3000);

        for (String w : driver.getWindowHandles()) {
            if (!w.equals(parent)) {
                driver.switchTo().window(w);
                break;
            }
        }
    }

    public String getCourseTitle(int index) {
        return courses.get(index).getText();
    }

    public void openCourseInNewTab(int index) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String href = courses.get(index).getAttribute("href");

        js.executeScript("window.open(arguments[0])", href);

        java.util.ArrayList<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        Thread.sleep(3000); // 🔥 IMPORTANT FIX
    }
}