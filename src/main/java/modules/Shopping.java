package main.java.modules;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import main.java.pages.InventoryPage;
import main.java.utility.DataUtility;

public class Shopping {
private WebDriver driver;
	public Shopping(WebDriver driver) {
		this.driver=driver;
	}
	public void addToCart(String testcase) throws EncryptedDocumentException, IOException {
		DataUtility rData=new DataUtility();
		String data=rData.getData(testcase);
		System.out.println(data);
	    InventoryPage iPage=new InventoryPage(driver);
	    iPage.addToCart(data);
	}
}
