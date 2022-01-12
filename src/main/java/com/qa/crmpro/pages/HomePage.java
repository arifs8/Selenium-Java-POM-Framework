package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtils;

public class HomePage extends BasePage {
	private WebDriver driver;
	private ElementUtils elementutil;
	
	By header = By.xpath("(//div[@class='header'])[1]");
	By accountName = By.cssSelector("span.user-display");
	
	//get title,verify header and logged in user
	public HomePage(WebDriver driver) {
		   this.driver = driver;
		   elementutil = new ElementUtils(driver);
		}
	
	public String getHomePageTitle() {
		return elementutil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE,10);
	}
	
	public String getHomePageHeaderText() {
		if(elementutil.doIsDisplayed(header)) {
			return elementutil.doGetText(header);
		}
		return null;
	}
	
	public String getLoggedInUser() {
		if(elementutil.doIsDisplayed(accountName)) {
			return elementutil.doGetText(accountName);
		}
		return null;
	}
		

}
