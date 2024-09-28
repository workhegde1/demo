package main.java.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class InventoryPage {
@FindBy(xpath="//select[@class='product_sort_container']")
private WebElement filter;
@FindBy(xpath="//select[@class='product_sort_container']//option[@value='za']")
private WebElement z_aOption;
@FindBy(xpath="//select[@class='product_sort_container']//option[@value='az']")
private WebElement a_zOption;
@FindBy(xpath="//select[@class='product_sort_container']//option[@value='lohi']")
private WebElement lohiOption;
@FindBy(xpath="//select[@class='product_sort_container']//option[@value='hilo']")
private WebElement hiloOption;
@FindBy(xpath="//button[@id='react-burger-menu-btn']")
private WebElement menuBtn;
@FindBy(xpath="//a[@id='logout_sidebar_link']")
private WebElement logOut;
@FindBy(xpath="//a[@class='shopping_cart_link']")
private WebElement shoppingCartLink;
@FindBy(xpath="//span[@class='title']")
private WebElement productTitle;
@FindBy(xpath="//div[@class='inventory_item_description']")
private List<WebElement> productList;
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void addToCart(String name) {
		for(WebElement product:productList) {
		String text=product.findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
         System.out.println(text);
		if(text.equalsIgnoreCase(name)) {
			product.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"))
			.click();
			break;
		}}
	}
	public void goToCart() {
		shoppingCartLink.click();
	}
	public String getProductTitle() {
		return productTitle.getText();
	}
	public void logOut() {
		menuBtn.click();
		logOut.click();
	}
}
