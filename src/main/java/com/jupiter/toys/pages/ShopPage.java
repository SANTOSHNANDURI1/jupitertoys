package com.jupiter.toys.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage extends BasePage{

	public ShopPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getProduct(String productName) throws Exception
	{
			List<WebElement> elements = driver.findElements(By.className("product"));
			for (WebElement element : elements) {
				if (element.findElement(By.className("product-title")).getText().equals(productName)) {
					return element;
				}
			}
			throw new Exception("No matching element");
	}
	
	public String getProductPrice(String productName) throws Exception {
		return getProduct(productName).findElement(By.className("product-price")).getText();
	}
	
	public void addProductToCart(String productName) throws Exception {
		getProduct(productName).findElement(By.className("btn-success")).click();
	}

	public int getCartCountIncrease() {
		return Integer.parseInt(driver.findElement(By.className("cart-count")).getText());		
	}
}


