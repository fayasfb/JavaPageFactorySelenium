package com.automationpractice.code.demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends StartPage {

	@FindBy(linkText = "REGISTER")
	@CacheLookup
	public WebElement txtREGISTER;

	@FindBy(name = "firstName")
	@CacheLookup
	public WebElement txtFirstName;

	@FindBy(name = "lastName")
	@CacheLookup
	public WebElement txtLastName;

	@FindBy(name = "phone")
	@CacheLookup
	public WebElement txtPhone;

	@FindBy(id = "userName")
	@CacheLookup
	public WebElement txtUserName;

	@FindBy(name = "address1")
	@CacheLookup
	public WebElement txtAddress1;

	@FindBy(name = "city")
	@CacheLookup
	public WebElement txtCity;

	@FindBy(css = "input[name='state']")
	@CacheLookup
	public WebElement txtState;

	@FindBy(css = "input[name='postalCode']")
	@CacheLookup
	public WebElement txtPostalCode;

	@FindBy(name = "country")
	@CacheLookup
	public WebElement drpCountry;

	@FindBy(id = "email")
	@CacheLookup
	public WebElement txtUserNamEmail;

	@FindBy(css = "input[name='password']")
	@CacheLookup
	public WebElement txtPassword;

	@FindBy(name = "confirmPassword")
	@CacheLookup
	public WebElement txtConfirmPassword;

	@FindBy(name = "submit")
	@CacheLookup
	public WebElement btnSubmit;

	public RegisterPage(WebDriver driver) {
		super(driver);
		waits = new WebDriverWait(driver, 10);
	}

	public UserNamePage loginToApp(String firstName, String lastName, String phone, String userName, String address,
			String city, String state, String postalCode, String drpcountry, String password) {
		waits.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(txtFirstName)));
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtPhone.sendKeys(phone);
		txtUserName.sendKeys(userName);
		txtAddress1.sendKeys(address);
		txtCity.sendKeys(city);
		txtState.sendKeys(state);
		txtPostalCode.sendKeys(postalCode);
		Select country = new Select(drpCountry);
		country.selectByVisibleText(drpcountry.toUpperCase());
		txtUserNamEmail.sendKeys(userName);
		txtPassword.sendKeys(password);
		txtConfirmPassword.sendKeys(password);
		btnSubmit.click();
		return PageFactory.initElements(driver, UserNamePage.class);
	}

}
