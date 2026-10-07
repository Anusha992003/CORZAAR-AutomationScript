package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(id="enter-6-digit-passcode")
	private WebElement otpField;
	
	@FindBy(xpath="//span[text()='Verify & Enter Learning Space']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Invalid OTP code']")
	private WebElement otpValidationMsg;
	
	@FindBy(xpath="/h1[contains(@class,'text-2xl sm:text-3xl')]")
	private WebElement homePageTitle;
	
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
	
	public void getHomePageTitle() {
		 System.out.println("Home Page title is: "+ driver.getTitle());
	}
	
	public void getMsgForInvalidMobile() {
		System.out.println("Validation msg: "+elementUtils.getText(mobileValidationMsg));
	}
	
	public void getMsgForInvalidOtp() {
		System.out.println("Validation msg: "+elementUtils.getText(otpValidationMsg));
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
