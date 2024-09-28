package test.java.tests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import main.java.base.TestBase;
import main.java.modules.Login;
import main.java.modules.Shopping;
public class LoginTest extends TestBase {
  @Test
  public void Login_1() throws EncryptedDocumentException, IOException {
 	  Login login = new Login(driver);
 	  login.login("Login_1");
 	  Assert.assertEquals(driver.getTitle(),"Swag Labs");
  }
  @Test
  public void Shopping_1() throws IOException {
 	  Login login = new Login(driver);
 	  login.login();
 	  Shopping shopping=new Shopping(driver);
 	  shopping.addToCart("Shopping_1");
  }
 }