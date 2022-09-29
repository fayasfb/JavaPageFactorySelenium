package com.automationpractice.code.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
	
	public WebDriver driver;
	public WebDriverWait waits;
	
	
  public StartPage(WebDriver driver) {
	  this.driver=driver;
	  waits=new WebDriverWait(driver, 10);
  }
  
  public LoginPage NavigateTo(String url) {
	//driver.manage().window().maximize();
	driver.get(url);
	return PageFactory.initElements(driver, LoginPage.class);
  }
  
 
  
}
