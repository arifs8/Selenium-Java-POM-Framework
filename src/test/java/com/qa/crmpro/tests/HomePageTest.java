package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.utils.Constants;

public class HomePageTest extends BaseTest {
	HomePage homePage;

	@BeforeClass
	public void homeSetup() {
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
	
}
