package web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPressPage extends AbstractPage{

	public WordPressPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToMainPage(String url){
		driver.get(url);
	}
	
	public void goTologInPage(){
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='navbar-login-link']"));
		ops.clickOnWebElement(loginButton);
	}
	
	public void fillInLogInForm(String username, String password){
		WebElement userNameField = driver.findElement(By.xpath("//*[@id='usernameOrEmail']"));
		WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement confirmationButton = driver.findElement(By.className("login__form-action"));
		ops.writeToWebElement(userNameField, username);
		ops.writeToWebElement(passwordField, password);	
		ops.clickOnWebElement(confirmationButton);

	
	}
	
	public void goToSearchPage(){
		WebElement searchButton = driver.findElement(By.xpath("//*[@href='/read/search']"));
		ops.clickOnWebElement(searchButton);
	}
	
	public void fillInSearchField(String value){
		WebElement searchField = driver.findElement(By.className("search__input-fade")).findElement(By.tagName("input"));
		ops.writeToWebElement(searchField, value);
		searchField.sendKeys(Keys.RETURN);	
	}
	
	public void clickOnArticle(){
		List<WebElement> articles = driver.findElements(By.className("reader-post-card__title"));
		for(WebElement element : articles){
			if (element.getText().contains("Firefox 55 and Selenium IDE")){
				ops.scrollToElement(element);
				sleep(10000);
				element.click();
				break;
			}
		}
	}	
	
	
	public void goToMySitePage(){
		WebElement mySiteButton = driver.findElement(By.xpath("//span[@class='masterbar__item-content' and text()='My Site']"));
		ops.clickOnWebElement(mySiteButton);
		sleep(10000);
	}
	
	public void clickOnSitePgesButton(){
		WebElement sitePagesButton = driver.findElement(By.xpath("//span[@class='menu-link-text' and text()='Site Pages']"));
		ops.clickOnWebElement(sitePagesButton);
	}
	
	public void clickOnWriteButton(){
		WebElement writeButton = driver.findElement(By.xpath("//span[@class='masterbar__item-content' and text()='Write']"));
		ops.clickOnWebElement(writeButton);
	}
	
	public void fillinArticleFields(String title, String text){
		WebElement titleField = driver.findElement(By.className("editor-title__input"));
		ops.writeToWebElement(titleField, title);
		WebElement textField = driver.findElement(By.className("tinymce"));
		ops.writeToWebElement(textField, text);
		sleep(10000);
		WebElement publishButton = driver.findElement(By.className("editor-publish-button"));
		ops.clickOnWebElement(publishButton);
		sleep(5000);
	}
	
	public void deleteArticle(){
		WebElement editButton = driver.findElement(By.className("web-preview__edit"));
		ops.clickOnWebElement(editButton);
		sleep(5000);
		WebElement moveToTrashButton = driver.findElement(By.xpath("//button[@class='button editor-delete-post__button is-borderless']"));
		ops.clickOnWebElement(moveToTrashButton);
		sleep(5000);
		WebElement MoveToTrashButtonConfirmation = driver.findElement(By.xpath("//span[@class='dialog__button-label' and text()='Move to trash']"));
		ops.clickOnWebElement(MoveToTrashButtonConfirmation);
		sleep(5000);
		//WebElement notRestoreButton = driver.findElement(By.xpath("//div[@class='dialog__action-buttons']/button[@class='button form-button']"));
		WebElement els = driver.findElement(By.cssSelector(".button.form-button:not(.is-primary)"));
		//ops.clickOnWebElement(notRestoreButton);
		els.click();
		sleep(10000);
		WebElement e = driver.findElement(By.className("section-nav-tab__text"));
	}
	
}
