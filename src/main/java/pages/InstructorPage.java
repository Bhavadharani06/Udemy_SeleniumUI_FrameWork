package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InstructorPage extends BasePage {

    public InstructorPage(WebDriver driver) {
        super(driver);
    }

    By linkedin = By.xpath("//a[contains(@href,'linkedin.com')]");
    By youtube = By.xpath("//a[contains(@href,'youtube.com')]");

    public void clickLinkedIn() {
        clickSocialLink(linkedin);
    }

    public void clickYouTube() {
        clickSocialLink(youtube);
    }

    private void clickSocialLink(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }
}