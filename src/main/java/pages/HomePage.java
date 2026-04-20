package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By searchBox = By.name("q");

    public void searchCourse(String courseName) {

        WebElement box = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox));

        box.clear();
        box.sendKeys(courseName, Keys.ENTER);
    }
}