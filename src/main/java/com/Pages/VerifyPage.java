package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class VerifyPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public VerifyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[text()='Verify']")
	private WebElement verifyModule;
	
	@FindBy(xpath="//h1[text()='Credential Verification']")
	private WebElement title;
	
	@FindBy(id="certificate-identification-number")
	private WebElement inputField;
	
	@FindBy(xpath="//span[text()='Verify Credential Status']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[@class='font-mono text-xs font-bold text-brand']")
	private WebElement certificateID;
	
	@FindBy(xpath="//h3[contains(@class,'text-base font-bold text-ink dark:text')]")
	private WebElement sectionTitle;
	
	public void clickVerify() {
		elementUtils.click(verifyModule);
	}
	
	public void getTitle() {
		String text=elementUtils.getText(title);
		System.out.println("Title of the page is: "+text);
	}
	
	public void enterID(String id) {
		elementUtils.sendKeys(inputField, id);
	}
	
	public void clickSubmitBtn() {
		elementUtils.click(submitBtn);
	}
	
	public void validateID(String id, String result) {
		switch (result) {
		case "valid":
			String a= elementUtils.getText(sectionTitle);
			System.out.println("Message for valid certificate ID: "+a);
			break;

		case "invalid":
			String b= elementUtils.getText(sectionTitle);
			System.out.println("Message for invalid certificate ID: "+b);
			break;
		}
	}
	
	public void verifyAgain(String id) {
		elementUtils.click(verifyModule);
		elementUtils.sendKeys(inputField, id);
		elementUtils.click(submitBtn);
		
	}
	
	public void verifyCertificate() {
		String a=inputField.getAttribute("value");
		String b=elementUtils.getText(certificateID);
		Assert.assertEquals(a, b);
		System.out.println("Certificate details are displayed correctly");
	}
	
	

}
