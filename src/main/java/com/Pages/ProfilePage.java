package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class ProfilePage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="(//div[contains(@class,'relative inline-flex items-center justify-cen')])[1]")
	private WebElement profileIcon;
	
	@FindBy(xpath="//a[@href='/profile']")
	private WebElement profileModule;
	
	@FindBy(xpath="//h1[text()='Learner Profile']")
	private WebElement title;
	
	@FindBy(id="email-address")
	private WebElement emailField;
	
	@FindBy(xpath="//span[text()='Save Profile Changes']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//h4[text()='Profile Updated']")
	private WebElement msg;
	
	public void clickProfileIcon() {
		elementUtils.click(profileIcon);
	}
	
	public void clickProfileModule() {
		elementUtils.click(profileModule);
	}
	
	public void getTitle() {
		String text=elementUtils.getText(title);
		System.out.println("Title of the page is: "+text);
	}
	
	public void enterMail(String mail) {
		elementUtils.sendKeys(emailField, mail);
	}
	
	public void clickSaveBtn() {
		elementUtils.click(saveBtn);
	}
	
	public void getMsg() {
		String a=elementUtils.getText(msg);
		System.out.println("Message: "+a);
	}
}
