package com.automationpractice.code.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserNamePage extends StartPage {
	String username="";
	@FindBy(xpath="//p/font/b[contains(text(), username)]")
    @CacheLookup
    public WebElement txtuserName;


	public UserNamePage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	}
	
	public UserNamePage registerUser(String username) {
		this.username=username;
		waits.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(txtuserName)));
		Assert.assertTrue(txtuserName.isDisplayed());
		return PageFactory.initElements(driver, UserNamePage.class);
	}
	
	

}
