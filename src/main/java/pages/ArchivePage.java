package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArchivePage {

	@FindBy(xpath = "//a[contains(@href,'archived')]")
	private WebElement archivedTab;

	@FindBy(xpath = "(//button[contains(@id,'dropdown-trigger')])[1]")
	private WebElement threeDots;

	@FindBy(xpath = "(//button[contains(.,'Unarchive')])[1]")
	private WebElement unarchiveBtn;

	// Getters
	public WebElement getArchivedTab() {
		return archivedTab;
	}

	public WebElement getThreeDots() {
		return threeDots;
	}

	public WebElement getUnarchiveBtn() {
		return unarchiveBtn;
	}

	// Business Logic
	public void clickOnArchive() {
		archivedTab.click();
	}
	
	public void unarchiveCourse() {
		threeDots.click();
		unarchiveBtn.click();
	}
}
