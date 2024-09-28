package main.java.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
@FindBy(xpath="//input[@id='user-name']")	
private WebElement userName; 
@FindBy(xpath="//input[@id='password']")	
private WebElement password;
@FindBy(xpath="//input[@id='login-button']")	
private WebElement loginButton;
@FindBy(xpath="//h3[@data-test='error']")
private WebElement error;
@FindBy(xpath="//h4[0]")
private WebElement userNamesText;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
public void login(String userName,String password) {
	this.userName.sendKeys(userName);
	this.password.sendKeys(password);
	loginButton.click();
}
public String getErrorMsg() {
	return error.getText();	
}
public String getUserNameText() {
	return userNamesText.getText();
}
}
