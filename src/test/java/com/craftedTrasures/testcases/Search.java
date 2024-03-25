package com.craftedTrasures.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.craftedTreasures.base.Base;

public class Search extends Base {

	WebDriver driver;

	public Search() {
		super();
	}

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
	public void searchWithvalidProduct() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
		Assert.assertTrue(driver.findElement(By.linkText("iPhone")).isDisplayed());

	}

	@Test
	public void searchWithNonExistingProduct() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("abc");
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).isDisplayed());
	}
}
