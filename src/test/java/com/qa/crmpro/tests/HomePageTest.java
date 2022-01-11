package com.qa.crmpro.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utils.Constants;

public class HomePageTest {
	
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop(); //to load property file
		driver= basePage.init_driver(prop);
		loginPage = new LoginPage(driver);	
		homePage = loginPage.doLogin("reshma4a1@gmail.com", "test@123");
	}
	
	@Test
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is : " +title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
	}
	
	@Test
	public void verifyHomePageHeader() {
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home page header is : " +header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}

	@Test
	public void verifyLoggedInUser() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Home page logged in user is : " +loggedInUser);
		Assert.assertEquals(loggedInUser, "Reshma shaik");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
