package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class OffersPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[text()='Offers']")
	private WebElement offersModule;
	
	@FindBy(xpath="//h1[contains(@class,'text-3xl sm:text-4xl font-black tex')]")
	private WebElement offersTitle;
	
	@FindBy(xpath="(//span[text()='Copy'])[1]")
	private WebElement copyBtn;
	
	@FindBy(xpath="//h4[text()='Copied to Clipboard!']")
	private WebElement copyMsg;
	
	@FindBy(xpath="//span[text()='Get My Referral Code']")
	private WebElement getCodeBtn;
	
	public void clickOffers() {
		elementUtils.click(offersModule);
	}
	
	public void getTitle() {
		String text=elementUtils.getText(offersTitle);
		System.out.println("Title of the page is: "+text);
	}
	
	public void clickCopy() {
		elementUtils.click(copyBtn);
	}
	
	public void getCopyMsg() {
		String text=elementUtils.getText(copyMsg);
		System.out.println("Message: "+text);
	}
	
	public void clickCodeBtn() {
		elementUtils.click(getCodeBtn);
	}
	


}
