package com.qa.crmpro.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utils.Constants;

public class LoginPageTest {
	
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver= basePage.init_driver(prop);
		loginPage = new LoginPage(driver);		
	}
	
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
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
