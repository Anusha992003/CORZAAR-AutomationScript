package com.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class SigninPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(xpath="(//button//span)[1]")
	private WebElement profileLogo;
	
	@FindBy(xpath="//h1[contains(@class,'text-2xl sm:text-3xl font')]")
	private WebElement signinPageTitle;
	
	@FindBy(id="learner-mobile-number")
	private WebElement mobileNumberField;
	
	@FindBy(id="full-name-(optional-for-existing-learners)")
	private WebElement fullNameField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sendOtpBtn;
	
	@FindBy(xpath="//span[text()='Failed to send OTP']")
	private WebElement mobileValidationMsg;
	
	@FindBy(xpath="//label[@for=\"enter-6-digit-passcode\"]")
	private WebElement otpPageVerification;
	
	@FindBy(xpath="//span[text()='One-time code sent to:']")
	private WebElement otpPage;
	
	@FindBy(id="enter-6-digit-passcode")
	private WebElement otpField;
	
	@FindBy(id="enter-6-digit-passcode")
	private List<WebElement> otpFieldDisplay;
	
	@FindBy(xpath="//span[text()='Verify & Enter Learning Space']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Invalid OTP code']")
	private WebElement otpValidationMsg;
	
	@FindBy(xpath="//h1[contains(@class,'text-2xl sm:text-3xl font-bla')]")
	private WebElement homePageTitle;
	
	@FindBy(xpath="//button[text()=' Change']")
	private WebElement changeBtn;
	
	public void verifyChangeBtn() {
		elementUtils.click(changeBtn);
		Assert.assertTrue(mobileNumberField.isDisplayed());
		elementUtils.click(sendOtpBtn);
	}
	
	public void clickSiginBtn() {
		elementUtils.click(signInBtn);
	}
	
	public boolean getPageTitle() {
		elementUtils.waitForVisibility(signinPageTitle);
		return elementUtils.isDisplayed(signinPageTitle);
	}
	
	public void enterMobileNumber(String mobile) {
		elementUtils.sendKeys(mobileNumberField,mobile);
	}
	
	public void enterFullName(String name) {
		elementUtils.sendKeys(fullNameField, name);
	}
	
	public void clickSendOtpBtn() {
		elementUtils.click(sendOtpBtn);
	}
	
	public boolean verifyOtpPage() {
		elementUtils.waitForVisibility(otpPageVerification);
		return elementUtils.isDisplayed(otpPageVerification);
	}
	
	public void otpPageNavigation(String mobile, String name) {
		elementUtils.sendKeys(mobileNumberField,mobile);
		elementUtils.sendKeys(fullNameField, name);
		elementUtils.click(sendOtpBtn);
	}
	
	public void enterOTP(String otp) {
		elementUtils.sendKeys(otpField, otp);
	}
	
	public void clickSubmitBtn() {
		elementUtils.click(submitBtn);
	}
	
	public String getHomePageTitle() {
		 return elementUtils.getText(homePageTitle);
	}
	
	
	public void getMsgForInvalidMobile() {
		System.out.println("Validation msg: "+elementUtils.getText(mobileValidationMsg));
	}
	
	public void getMsgForInvalidOtp() {
		System.out.println("Validation msg: "+elementUtils.getText(otpValidationMsg));
	}
	
	public void validateEmptyMobileField() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		boolean isRequired=(Boolean) js.executeScript("return arguments[0].required", mobileNumberField);
		boolean isEmpty=(Boolean) js.executeScript("return arguments[0].validity.valueMissing;", mobileNumberField);
		Assert.assertTrue(isRequired, "Mobile number field is not required");
		Assert.assertTrue(isEmpty, "Mobile number field validation failed");
	}
	
	public void validateEmptyOTPField() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		boolean isRequired=(Boolean) js.executeScript("return arguments[0].required", otpField);
		boolean isEmpty=(Boolean) js.executeScript("return arguments[0].validity.valueMissing;", otpField);
		Assert.assertTrue(isRequired, "OTP field is not required");
		Assert.assertTrue(isEmpty, "OTP field validation failed");
	}
	
	public void validateOptionalFullName() {
//		elementUtils.sendKeys(mobileNumberField, "9876543210");
//		fullNameField.clear();
//		elementUtils.click(submitBtn);
	//	elementUtils.waitForVisibility(otpField);
		Assert.assertTrue(elementUtils.isDisplayed(otpField),"Form does not proceed with empty full name");
	}
	
	public void validateMobileLength() {
		String a=mobileNumberField.getAttribute("value");
		Assert.assertTrue(a.length()<=10,"Mobile number field accepts more than 10 characters");
	}
	
	public void validateProfileLogo() {
		elementUtils.waitForVisibility(profileLogo);
		String a=elementUtils.getText(profileLogo);
		Assert.assertFalse(a.trim().isEmpty(), "Profile logo initials are not displayed");
		System.out.println("Profile logo initials after login: "+a);
	}
	
	public boolean isOtpFieldDisplayed() {
		return otpFieldDisplay.size()>0;
	}
	
	public HomePage doLogin(String mobile, String name, String otp) {
		elementUtils.click(signInBtn);
		elementUtils.sendKeys(mobileNumberField,mobile);
		elementUtils.sendKeys(fullNameField, name);
		elementUtils.click(sendOtpBtn);
		elementUtils.sendKeys(otpField, otp);
		elementUtils.click(submitBtn);
		return new HomePage(driver);
	}

}
