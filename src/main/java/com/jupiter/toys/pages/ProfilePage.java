package com.jupiter.toys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	public String getWelcomeMessage(String username) {
		return driver.findElement(By.tagName("h1")).getText();		
	}

}
