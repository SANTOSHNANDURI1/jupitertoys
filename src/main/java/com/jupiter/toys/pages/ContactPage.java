package com.jupiter.toys.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage{
	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	private String getFieldErrorMessage(By locater) { //pass in the locator
		List<WebElement> elements = driver.findElements(locater);
		if ( elements.size() > 0 ) {
			return elements.get(0).getText();
		}
		return "";
	}
	
	public void setForename(String forename) {
		driver.findElement(By.id("forename")).sendKeys(forename);
	}
	
	public void setEmail(String strEmail) {
		
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.clear();
		emailElement.sendKeys(strEmail);
	}
	
	public void setTelephone(String strTelephone) {
		
		WebElement telephone = driver.findElement(By.id("telephone"));
		telephone.clear();
		telephone.sendKeys(strTelephone);
	}
	
	public void setMessage(String message) {
		driver.findElement(By.id("message")).sendKeys(message);
	}
	
	public String getForenameErrorMessage() {
		return getFieldErrorMessage(By.id("forename-err"));
	}
	
	public String getEmailErrorMessage() {
		return getFieldErrorMessage(By.id("email-err"));
	}
	
	public String getTelephoneErrorMessage() {
		return getFieldErrorMessage(By.id("telephone-err"));
	}
	
	public String getMessageFieldErrorMessage() {
		return getFieldErrorMessage(By.id("message-err"));
	}
	
	public void clickSubmitButton() {
		driver.findElement(By.linkText("Submit")).click();		
	}

	public String getConfirmationMessage() {
		
		WebElement confirmationMessage = (new WebDriverWait(driver,Duration.ofSeconds(60))).until(ExpectedConditions.presenceOfElementLocated(By.className("alert-success")));
		return confirmationMessage.getText();
	}
}


