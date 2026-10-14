package com.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy(id="full-legal-name-(for-certificates)")
	private WebElement nameField;
	
	@FindBy(xpath="//h2[contains(@class,'text-xl font-bold text-ink ')]")
	private WebElement verifySave;
	
	@FindBy(xpath="//span[contains(text(),'Total claims: ')]")
	private WebElement totClaims;
	
	@FindBy(xpath="//*[contains(@class,'transition-colors hover:bg-slate-50/80 dark:hover')]")
	private List<WebElement> claimsCount;
	
	public void clickProfileIcon() {
		elementUtils.click(profileIcon);
	}
	
	public void clickProfileModule() {
		elementUtils.click(profileModule);
	}
	
	public void moveToProfilePage() {
		elementUtils.click(profileIcon);
		elementUtils.click(profileModule);
	}
	
	public void getTitle() {
		String text=elementUtils.getText(title);
		System.out.println("Title of the page is: "+text);
	}
	
	public void enterName(String name) {
		elementUtils.sendKeys(nameField, name);
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
	
	public String getNameValidation() {
		return elementUtils.getAttribute(nameField, "validationMessage");
	}
	
	public String getMailValidation() {
		return elementUtils.getAttribute(emailField, "validationMessage");
	}
	
	public void verifySavedChanges() {
		String a=elementUtils.getText(verifySave);
		String b=elementUtils.getAttribute(nameField, "value");
		Assert.assertEquals(a, b, "Saved changes is not updated correctly");
	}
	
	public void validateClaimsCount() {
		String a=elementUtils.getText(totClaims);
		int a1=Integer.parseInt(a.replaceAll("\\D+", ""));
		int b=claimsCount.size();
		Assert.assertEquals(a1, b, "Refund claims count is not matching");
	}
	
	public String getFullNameValue() {
		return elementUtils.getAttribute(nameField, "value");
	}
}
