package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AllFunctionality;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class CartPage {

    WebDriver driver;
    AllFunctionality util = new AllFunctionality();

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(.,'Remove')]")
    public List<WebElement> removeButtons;

    @FindBy(xpath = "//div[contains(@class,'shopping-item_container')]//a[contains(@href,'/course/')]")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//span[text()='Save for Later']/parent::button")
    public WebElement saveForLaterBtn;

    public void clearCart() throws InterruptedException {
        for (WebElement btn : removeButtons) {
            btn.click();
            Thread.sleep(1000);
        }
    }

    public int getCartCount() {
        return cartItems.size();
    }

    public int getUniqueItemCount() {

        Set<String> set = new HashSet<>();

        for (WebElement e : cartItems) {
            set.add(e.getText().trim());
        }

        return set.size();
    }

    public void clickSaveForLater() {
        util.click(driver, saveForLaterBtn);
    }

    public boolean isCartEmpty() {
        return driver.getPageSource().toLowerCase().contains("your cart is empty");
    }
}