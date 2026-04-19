package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ArchivePage;
import pages.LearningToolsPage;
import pages.SignUpPage;
import pages.MyLearningPage;
import pages.MyListPage;
import pages.WishlistPage;

public class Pages {
	public static SignUpPage signUpPage;
	public static MyLearningPage myLearningPage;
	public static MyListPage myListPage;
	public static WishlistPage wishlistPage;
	public static ArchivePage archivePage;
	public static LearningToolsPage learningToolsPage;
	

	public static void loadAllPages(WebDriver driver) {

		signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		myLearningPage = PageFactory.initElements(driver, MyLearningPage.class);
		myListPage = PageFactory.initElements(driver, MyListPage.class);
		wishlistPage = PageFactory.initElements(driver, WishlistPage.class);
		archivePage = PageFactory.initElements(driver, ArchivePage.class);
		learningToolsPage = PageFactory.initElements(driver, LearningToolsPage.class);
	}

}
