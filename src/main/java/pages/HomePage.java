package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(css = "button[type='submit']")
	private WebElement searchBtn;

	public void searchCourse(String course) throws InterruptedException {
		Thread.sleep(2000);
		searchBox.click();

		searchBox.clear();
		wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(course);
		searchBtn.click();
		Thread.sleep(9000);
	}
}
