package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonstepsPage {

	 WebDriver driver;
	    WebDriverWait wait;
	    Actions actions;

	    public CommonstepsPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        actions = new Actions(driver);
	    }

	    public void clickExplore() {
	        WebElement explore = wait.until(
	            ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Explore']"))
	        );
	        explore.click();
	    }

	    public void selectCategory(String category) throws InterruptedException {
	        WebElement cat = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[text()='" + category + "']")
	            )
	        );
	        cat.click();
	        Thread.sleep(10000);
	    }

	    public void selectSubCategory(String subCategory) {

	        WebElement sub = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//span[normalize-space()='" + subCategory + "']")
	            )
	        );

	        wait.until(ExpectedConditions.elementToBeClickable(sub));

	        try {
	            sub.click();
	        } catch (Exception e) {
	            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", sub);
	        }
	    }
	    
	    public String clickFirstCourse() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        // 1️⃣ Wait for loader to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.cssSelector("div[data-purpose='loading-spinner']")
	        ));

	        // 2️⃣ Wait for courses
	        List<WebElement> courses = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                By.xpath("//a[contains(@href,'/course/')]")
	        ));

	        // 3️⃣ Scroll to top
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");

	        // 4️⃣ Re-fetch elements
	        courses = driver.findElements(By.xpath("//a[contains(@href,'/course/')]"));

	        // 5️⃣ Get first course
	        WebElement firstCourse = courses.get(0);

	        // ✅ ADD THIS LINE (VERY IMPORTANT)
	        String url = firstCourse.getAttribute("href");

	        wait.until(ExpectedConditions.elementToBeClickable(firstCourse));

	        firstCourse.click();

	        return url; // ✅ now it works
	    }

}
