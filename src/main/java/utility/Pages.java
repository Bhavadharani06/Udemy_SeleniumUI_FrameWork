package utility;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.PageFactory;

import pages.AllCoursesPage;
import pages.ArchivePage;
import pages.LearningToolsPage;
import pages.SignUpPage;
import pages.MyListPage;
import pages.WishlistPage;

public class Pages {
	public static SignUpPage signUpPage;
	public static MyListPage myListPage;
	public static WishlistPage wishlistPage;
	public static ArchivePage archivePage;
	public static LearningToolsPage learningToolsPage;
	public static AllCoursesPage allCoursesPage;
	

	public static void initPages(WebDriver driver) {

		signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		myListPage = PageFactory.initElements(driver, MyListPage.class);
		wishlistPage = PageFactory.initElements(driver, WishlistPage.class);
		archivePage = PageFactory.initElements(driver, ArchivePage.class);
		learningToolsPage = PageFactory.initElements(driver, LearningToolsPage.class);
		allCoursesPage = PageFactory.initElements(driver, AllCoursesPage.class);
	}

}
