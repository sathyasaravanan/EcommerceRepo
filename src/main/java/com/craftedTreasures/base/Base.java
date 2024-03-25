package com.craftedTreasures.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cratedTreasures.utils.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Base() {

		prop = new Properties();
		dataProp = new Properties();

	File f2 = new File("C:\\Automation\\SeleniumFramework\\EcommerceProject\\src\\main\\java\\com\\craftedTreasures\\properties\\testData.properties");
		File f = new File("C:\\Automation\\SeleniumFramework\\EcommerceProject\\src\\main\\java\\com\\craftedTreasures\\properties\\Config.properties");
		try {
			FileInputStream fis2 = new FileInputStream(f2);
			dataProp.load(fis2);
		} catch (Throwable e1) {

			e1.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	public WebDriver driverInitialisation(String browserName) {

		if (browserName.equals("CHROME")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get("https://www.jetblue.com/");
		
		return driver;
	}

}
