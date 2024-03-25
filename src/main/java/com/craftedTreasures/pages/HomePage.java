package com.craftedTreasures.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver drv;

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccount;
	@FindBy(linkText = "Login")
	private WebElement lgnBtn;
	@FindBy(linkText = "Register")
	private WebElement registerBtn;

	public HomePage(WebDriver driver) {

		this.drv = driver;
		PageFactory.initElements(drv, this);

	}

	public void clickMyaccount() {
		myAccount.click();
	}
	public void clickRegister() {
		registerBtn.click();
	}
	public void clickLogin() {
		lgnBtn.click();
	}
}
