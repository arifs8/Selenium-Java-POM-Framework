package com.qa.crmpro.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			System.out.println("locator is  : " + locator);
			element = driver.findElement(locator);
			System.out.println("Webelement created successfully");
		} catch (Exception e) {
			System.out.println("Exception occured for the locator : " + locator);
		}

		return element;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();

	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doDragAndDrop(By source, By target) {
		Actions action = new Actions(driver);
		WebElement sourceele = getElement(source);
		WebElement targetele = getElement(target);
		action.dragAndDrop(sourceele, targetele).build().perform();

	}

	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}

	public WebElement waitForElementPresent(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	public String waitForTitleToBePresent( String title,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

}
