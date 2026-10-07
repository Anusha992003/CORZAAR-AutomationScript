package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class WalletPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public WalletPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@href=\"/wallet\"]")
	private WebElement walletModule;
	
	@FindBy(xpath="//h1[text()='Rewards Wallet & Referrals']")
	private WebElement title;
	
	@FindBy(xpath="//span[contains(@class,'text-4xl sm:text-5xl font-bl')]")
	private WebElement balance;
	
	@FindBy(xpath="//span[text()='Copy Code']")
	private WebElement copyBtn;
	
	@FindBy(xpath="//h4[text()='Referral Code Copied!']")
	private WebElement copyMsg;
	
	public void clickWallet() {
		elementUtils.click(walletModule);
	}
	
	public void getTitle() {
		String text=elementUtils.getText(title);
		System.out.println("Title of the page is: "+text);
	}
	
	public void getBalance() {
		String a=elementUtils.getText(balance);
		System.out.println("Balance: "+a);
	}
	
	public void clickCopyCodeBtn() {
		elementUtils.click(copyBtn);
	}
	
	public void veriyCopyMsg() {
		String b=elementUtils.getText(copyMsg);
		System.out.println("Message: "+b);
	}

}
