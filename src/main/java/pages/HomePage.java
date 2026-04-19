package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;

    public void searchCourse(String course) throws InterruptedException {
        searchBox.sendKeys(course, Keys.ENTER);
        Thread.sleep(5000); 
    }

    public String getSearchText() {
        return searchBox.getAttribute("value");
    }
}