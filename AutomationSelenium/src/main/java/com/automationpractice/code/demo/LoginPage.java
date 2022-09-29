package com.automationpractice.code.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends StartPage {

	@FindBy(linkText = "REGISTER")
	@CacheLookup
	public WebElement linkREGISTER;

	public LoginPage(WebDriver driver) {
		super(driver);
		waits = new WebDriverWait(driver, 10);
	}

	public RegisterPage clickregister() {
		waits.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(linkREGISTER)));
		linkREGISTER.click();
		return PageFactory.initElements(driver, RegisterPage.class);
	}
}
