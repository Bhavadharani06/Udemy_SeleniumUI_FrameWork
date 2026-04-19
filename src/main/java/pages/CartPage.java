
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CartPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}

	// Using a 'By' locator to ensure we always find a fresh instance of the button
	private By closePopupLocator = By.xpath("//button[@data-purpose='close-popup']");

	public boolean isCourseAdded() {
		// 1. Wait for the "Added to cart" text to appear (based on image_9f7f25.jpg)
		WebElement addedToCartText = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Added to cart')]")));

		boolean status = addedToCartText.isDisplayed();

		// 2. Wait for the close button to be clickable
		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closePopupLocator));

		// 3. Click using JS to bypass any overlay issues
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);

		return status;
	}
}