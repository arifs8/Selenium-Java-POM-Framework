package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.utils.Constants;

public class LoginPageTest extends BaseTest {
	

	@Test
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed");
	}
	
	@Test
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

}
