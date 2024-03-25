package com.craftedTrasures.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.craftedTreasures.base.Base;
import com.craftedTreasures.pages.HomePage;
import com.craftedTreasures.pages.LoginPage;
import com.cratedTreasures.utils.Utilities;

public class Login extends Base {

	public Login() {

		super();

	}

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = driverInitialisation(prop.getProperty("browserName"));

	}

	@AfterMethod
	// teardown method uses aftermethod annotation bcoz driver needs to be closed
	// irrespective
	// of test method pass or fail
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginwithvalidcedentials() {
		HomePage home = new HomePage(driver);
		LoginPage lgn = new LoginPage(driver);
		home.clickMyaccount();
		home.clickLogin();
		lgn.lgnWithValidData(prop.getProperty("validEmail"), prop.getProperty("validPwd"));
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

	@Test
	public void loginwithinvalidcedentials() {

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.timeStamp());
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("saro1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String expectedInvalidLgnMsg = prop.getProperty("NoEmailWarning");
		String actualInvalidLgnMsg = driver
				.findElement(By.xpath("//*[@id=\"account-login\"]/div[contains(text(),'Warning')]")).getText();
		System.out.println(actualInvalidLgnMsg);
		Assert.assertEquals(actualInvalidLgnMsg, expectedInvalidLgnMsg);
	}
	// email address will be different every time we run the method

}
