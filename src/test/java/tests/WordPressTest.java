package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import web.WordPressPage;

public class WordPressTest extends BaseTest{
	
	String url = "https://wordpress.com/";
	String username = "telranenglish";
	String password = "TREnglish";
	String searchValue = "Selenium";
	String titleArticle = "some title";
	String textArticle = "some text";
	
	WordPressPage wordPressPage;
	
	@BeforeClass
	public void setUP(){
		this.wordPressPage = new WordPressPage(driver);
	}
	
	@Test(priority=0)
	public void goToStartPage(){
		wordPressPage.goToMainPage(url);
	}
	
	@Test(priority=1)
	public void openLogInPage(){
		wordPressPage.goTologInPage();
	}
	
	@Test(priority=2)
	public void logIn(){
		wordPressPage.fillInLogInForm(username, password);
	}
	
	@Test(priority=3)
	public void goToSearchPage(){
		wordPressPage.goToSearchPage();
	}
	
	@Test(priority=4)
	public void fillInSearchField(){
		wordPressPage.fillInSearchField(searchValue);
	}
	
	@Test(priority=5)
	public void goToArticlepage(){
		wordPressPage.clickOnArticle();
	}
	
	@Test(priority=6)
	public void goToMySitePage(){
		wordPressPage.goToMySitePage();
	}
	
	@Test(priority=7)
	public void doToSitePagesPage(){
		wordPressPage.clickOnSitePgesButton();
	}
	
	@Test(priority=8)
	public void writeArticle(){
		wordPressPage.clickOnWriteButton();
		wordPressPage.fillinArticleFields(titleArticle, textArticle);
	}
	
	@Test(priority=9)
	public void deleteArticle(){
		wordPressPage.deleteArticle();
	}

}
