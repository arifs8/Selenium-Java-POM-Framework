package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtils;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtils elementutil;
	
	//1.By locators 
	
	By emailId = By.name("email");
	By password = By.name("password");
	By loginBtn = By.xpath("//div[text()='Login']");
	By signUpLink = By.linkText("Sign Up");

	
	//2.create constructor of page class
	public LoginPage(WebDriver driver) {
	   this.driver = driver;
	   elementutil = new ElementUtils(driver);
	}
	
	//3.Actions
	public String getLoginPageTitle() {
		return elementutil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE,10);

	}
	
	public boolean verifySignUpLink() {
		return elementutil.doIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(String username,String password) {
		//elementutil.waitForElementPresent(10, this.emailId);
		elementutil.doSendKeys(this.emailId,username);
		elementutil.doSendKeys(this.password,password);
		elementutil.doClick(loginBtn);
		return new HomePage(driver);
	}
}
