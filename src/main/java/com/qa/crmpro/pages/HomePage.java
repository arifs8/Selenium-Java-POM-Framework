package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

public class HomePage extends BasePage {
	private WebDriver driver;
	
	By header = By.xpath("(//div[@class='header'])[1]");
	By accountName = By.cssSelector("span.user-display");
	
	//get title,verify header and logged in user
	public HomePage(WebDriver driver) {
		   this.driver = driver;	
		}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderText() {
		if(driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}
	
	public String getLoggedInUser() {
		if(driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText();
		}
		return null;
	}
		

}
