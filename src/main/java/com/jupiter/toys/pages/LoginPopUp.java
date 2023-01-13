package com.jupiter.toys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPopUp extends BasePage {
	public LoginPopUp(WebDriver driver) {
		super(driver);
	}
	public void setUsername(String username) {
		driver.findElement(By.id("loginUserName")).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(By.id("loginPassword")).sendKeys(password);	
	}

	public void clickLoginButton() {
		driver.findElement(By.className("btn-primary")).click();
	}

	public String getLoginErrorMessage() {
		return driver.findElement(By.id("login-error")).getText();
	}
}


