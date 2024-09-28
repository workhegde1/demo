package main.java.modules;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import main.java.pages.HomePage;
import main.java.utility.DataUtility;
import main.java.utility.ReadProperties;
public class Login {
private	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
			}
public void login(String testCase) throws EncryptedDocumentException, IOException {
	DataUtility rData=new DataUtility();
	String data=rData.getData(testCase);
	String user=data.split(",")[0];
	String password=data.split(",")[1];
	login(user,password);
}
public void login() throws IOException {
	Properties pro = ReadProperties.readConfig();
	String userName=pro.getProperty("username");
	String password=pro.getProperty("password");
	login(userName,password);
}
private void login(String userName,String password){
	HomePage homePage = new HomePage(driver);
	homePage.login(userName, password);
}
}
