package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class SignOutPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public SignOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//button[text()='Sign Out']")
	private WebElement signOutOption;
	
	@FindBy(xpath="//div[@class='text-center space-y-2']")
	private WebElement loginPage;
	
	public void clickSignOutOption() {
		elementUtils.click(signOutOption);
	}
	
	public void verifySignOut() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
		String a=elementUtils.getText(loginPage);
		System.out.println("Displayed title is: "+a);
	}

}
