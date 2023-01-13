package com.jupitertoys.tests;

import org.junit.Assert;
import org.junit.Test;

import com.jupiter.toys.pages.ContactPage;
import com.jupiter.toys.pages.HomePage;

public class ContactPageTests extends BaseTestSuite{

	@ Test
	public void mandatoryFieldsErrorMessagesTest() {
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = new ContactPage(driver);
		
		//click contact menu from home page
		homePage.clickContactMenu();
		//submitting an empty contact details form
		contactPage.clickSubmitButton();
		
		Assert.assertEquals("Verify Mandatory surname error message", "Forename is required", contactPage.getForenameErrorMessage());
		Assert.assertEquals("Verify Mandatory email error message", "Email is required", contactPage.getEmailErrorMessage());
		Assert.assertEquals("Verify Mandatory Message Field error message", "Message is required", contactPage.getMessageFieldErrorMessage());
		
		//enter values into the mandatory fields
		contactPage.setForename("SPECIAL OFFICER");
		contactPage.setEmail("abc@xyz.com");
		contactPage.setMessage("Sample Text");		
		
		Assert.assertEquals("Verify Mandatory surname error message has gone", "", contactPage.getForenameErrorMessage());
		Assert.assertEquals("Verify Mandatory email error message has gone", "", contactPage.getEmailErrorMessage());
		Assert.assertEquals("Verify Mandatory Message Field error message has gone", "", contactPage.getMessageFieldErrorMessage());
		
		//submit contact details form
 		contactPage.clickSubmitButton();
	}
	
	@Test
	public void invalidValuesCorrectionAndSubmissionTest() {
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = new ContactPage(driver);
		String forename = "Special Officer";
		
		//click contact menu from home page
		homePage.clickContactMenu();
		
		//enter values into the fields
		contactPage.setForename(forename);
		contactPage.setEmail("abc@xyzcom");
		contactPage.setTelephone("abcd1234");
		contactPage.setMessage("Sample Text");	
		
		Assert.assertEquals("Verify invalid email error message", "Please enter a valid email", contactPage.getEmailErrorMessage());
		Assert.assertEquals("Verify invalid telephone error message", "Please enter a valid telephone number", contactPage.getTelephoneErrorMessage());
		
		//enter valid values into the fields
		contactPage.setTelephone("12345678");
		contactPage.setEmail("abc@xyz.com");
				
		Assert.assertEquals("Verify invalid email error message has gone", "", contactPage.getEmailErrorMessage());
		Assert.assertEquals("Verify invalid telephone error message has gone", "", contactPage.getTelephoneErrorMessage());

		//submitting contact details
		contactPage.clickSubmitButton();
	}
	
	@Test
	public void formSubmissionMessageTest() {
		
		HomePage homePage = new HomePage(driver);
	
		//click contact menu from home page
		ContactPage contactPage = homePage.clickContactMenu();
		
		//enter values into the fields
		String forename = "Special Officer";
		contactPage.setForename(forename);
		contactPage.setEmail("abc@xyz.com");
		contactPage.setTelephone("12345678");
		contactPage.setMessage("Sample Text");	
		
		//submit contact details
		contactPage.clickSubmitButton();
		
		Assert.assertEquals("Verify confirmation message", "Thanks " +forename+ ", we appreciate your feedback.", contactPage.getConfirmationMessage());
		
	}
	

}
