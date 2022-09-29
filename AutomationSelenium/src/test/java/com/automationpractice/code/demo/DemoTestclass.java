package com.automationpractice.code.demo;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationpractice.code.demo.LoginPage;
import com.automationpractice.code.demo.PropertiesReader;
import com.automationpractice.code.demo.RegisterPage;
import com.automationpractice.code.demo.StartPage;
import com.automationpractice.code.demo.UserNamePage;
import com.github.javafaker.Faker;

public class DemoTestclass {

	public WebDriver driver;
	public StartPage startPage;
	public LoginPage loginPage;
	public RegisterPage registerPage;
	public UserNamePage userNamePage;
	Properties properties;
	public SoftAssert softAssert;
	public String userName;
	public String password;

	@BeforeTest(alwaysRun = true)
	public void beforeTest() throws Exception {
		softAssert = new SoftAssert();
		properties = new PropertiesReader().readPropertyFile();
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			if (System.getProperty("os.name").indexOf("nix") >= 0
					|| System.getProperty("os.name").indexOf("nux") >= 0) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver = new ChromeDriver();
			}
		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		startPage = new StartPage(driver);
		loginPage = startPage.NavigateTo(properties.getProperty("url"));
	}

	@Test
	public void SignUpTest() {
		userName = new Faker().name().firstName() + new Faker().number().digits(5) + "@demo.com";
		password = new Faker().name().firstName() + new Faker().number().digits(2) + "#%$#%^";
		registerPage = loginPage.clickregister();
		userNamePage = registerPage.loginToApp(new Faker().name().firstName() + new Faker().number().digits(7),
				new Faker().name().lastName() + new Faker().number().digits(7), new Faker().number().digits(10),
				userName, properties.getProperty("address").toString(), properties.getProperty("city").toString(),
				properties.getProperty("state").toString(), properties.getProperty("postalCode").toString(),
				properties.getProperty("drpcountry").toString(), password);
		userNamePage.registerUser(userName);
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
