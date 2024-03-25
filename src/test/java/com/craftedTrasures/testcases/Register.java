package com.craftedTrasures.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.craftedTreasures.base.Base;
import com.cratedTreasures.utils.Utilities;

public class Register extends Base {

	public Register() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = driverInitialisation(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	// teardown method uses aftermethod annotation bcoz driver needs to be closed
	// irrespective
	// of test method pass or fail
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void registerWithAllFields() {

		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.timeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("confirmpassword"));
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree' and @value='1']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String expectedSuccessMessage = dataProp.getProperty("AccountSuccessMessage");
		String actualsuccessMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(expectedSuccessMessage.contains(actualsuccessMessage));

	}

}
