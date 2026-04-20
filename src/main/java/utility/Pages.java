package utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.*;


import pages.CommonstepsPage;
import pages.Explore1Page;

public class Pages {


    public static HomePage homePage;
    public static SearchResultsPage searchResultsPage;
    public static CartPage cartPage;
   // public static SignupPage signupPage;
    public static Explore1Page page1;
	public static CommonstepsPage common;

    public static void initPages(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        page1=PageFactory.initElements(driver, page1.class);
        common=PageFactory.initElements(driver, common.class);
}

	
	
    
}

