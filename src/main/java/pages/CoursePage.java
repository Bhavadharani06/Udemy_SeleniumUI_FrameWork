package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoursePage extends BasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    By addToCart = By.xpath("//button[contains(.,'Add to cart') or contains(.,'Buy')]");

    By instructor = By.xpath("//a[contains(normalize-space(),'Angela Yu')]");

    public void clickAddToCart() {

        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(addToCart));

        btn.click();
    }

    public void clickInstructor() {

        WebElement ins = wait.until(
                ExpectedConditions.presenceOfElementLocated(instructor));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ins);
        js.executeScript("arguments[0].click();", ins);
    }
}