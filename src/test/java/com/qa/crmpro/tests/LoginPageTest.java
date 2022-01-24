package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ExcelUtil;

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
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = ExcelUtil.getTestData("login");
		return data;
	}
	
	@Test (dataProvider = "getLoginTestData")
	public void loginTest(String username,String password) {
		//loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		loginPage.doLogin(username,password);
	}

}
