package com.jupiter.toys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	protected WebDriver driver;	
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public ContactPage clickContactMenu() {
		driver.findElement(By.cssSelector("#nav-contact a")).click();;
		return new ContactPage(driver);
	}
	
	public LoginPopUp clickLoginMenu() {
		driver.findElement(By.cssSelector("#nav-login a")).click();
		return new LoginPopUp(driver);
	}
	
	public ProfilePage clickProfileMenu() {
		driver.findElement(By.cssSelector("#nav-user a")).click();
		return new ProfilePage(driver);
	}
	
	public ShopPage clickShopMenu() {
		driver.findElement(By.cssSelector("#nav-shop a")).click();
		return new ShopPage(driver);
	}
}
