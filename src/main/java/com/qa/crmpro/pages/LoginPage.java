package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	//1.By locators 
	
	By emailId = By.name("email");
	By password = By.name("password");
	By loginBtn = By.xpath("//div[text()='Login']");
	By signUpLink = By.linkText("Sign Up");

	
	//2.create constructor of page class
	public LoginPage(WebDriver driver) {
	   this.driver = driver;	
	}
	
	//3.Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username,String password) {
		driver.findElement(this.emailId).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginBtn).click();
		return new HomePage(driver);
	}
}
