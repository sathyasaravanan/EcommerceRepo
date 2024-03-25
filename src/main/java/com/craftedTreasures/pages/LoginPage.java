package com.craftedTreasures.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver drv;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement lgnBtn;

	public LoginPage(WebDriver driver) {

		this.drv = driver;
		PageFactory.initElements(driver, this);

	}

	public void lgnWithValidData(String emailid,String pwd) {
		email.sendKeys(emailid);
		password.sendKeys(pwd);
		lgnBtn.click();
	}
	
}
