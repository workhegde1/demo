package main.java.base;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import main.java.utility.DataUtility;
import main.java.utility.ReadProperties;

public class TestBase implements ITestListener{
	protected WebDriver driver;
	public TestBase() {
	}
	@BeforeMethod
	public void initDriver() throws IOException{
			 System.setProperty("webdriver.chrome.driver",ReadProperties.readConfig().getProperty("chromeDriver"));
			 ChromeOptions options=new ChromeOptions();
			 options.setBinary(ReadProperties.readConfig().getProperty("chromeBinary"));
			 driver =new ChromeDriver(options);
			 driver.manage().window().maximize();
			 driver.get(ReadProperties.readConfig().getProperty("url"));
		}
	@AfterMethod
	public void shutDownDriver() {
		driver.quit();
	}
	public void onTestSuccess(ITestResult result) {
      	DataUtility util=new DataUtility();
      	try {
			util.writeResult(result.getName(),1);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
}
