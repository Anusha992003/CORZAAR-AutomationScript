package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class RefundPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public RefundPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@href=\"/learning\"]")
	private WebElement learning;
	
	@FindBy(xpath="//*[text()='active']")
	private WebElement courseCard;
	
	@FindBy(xpath="//*[text()='Request Refund']")
	private WebElement refundOption;
	
	@FindBy(xpath="//h3[@class='text-lg font-bold text-ink dark:text-dark-ink']")
	private WebElement popupTitle;
	
	@FindBy(id="reason-for-refund")
	private WebElement reasonField;
	
	@FindBy(xpath="//span[text()='Cancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//span[text()='Confirm Refund Claim']")
	private WebElement submitBtn;
	
	@FindBy(xpath="text-sm font-semibold")
	private WebElement submitMsg;
	
	public void clickLearning() {
		elementUtils.click(learning);
	}
	
	public void clickCourseCard() {
		elementUtils.waitForVisibility(courseCard);
		elementUtils.click(courseCard);
	}
	
	public void clickRefundBtn() {
		elementUtils.click(refundOption);
	}
	
	public void getPopupTitle() {
		String a=elementUtils.getText(popupTitle);
		System.out.println("Title of the popup is: "+a);
	}
	
	public void enterReason(String reason) {
		elementUtils.sendKeys(reasonField, reason);
	}
	
	public void submitWithoutReason() {
		elementUtils.click(submitBtn);
	}
	
	public String getReasonValidationMessage() {
		return elementUtils.getAttribute(reasonField, "validationMessage");
	}
	
	public void confirmRefund() {
		elementUtils.click(submitBtn);
	}
	
	public void getMsgAfterSubmit() {
		String a=elementUtils.getText(submitMsg);
		System.out.println("Message: "+a);
	}
	
	public void clickCancel() {
		elementUtils.click(cancelBtn);
	}
	
	public boolean isRefundPopupClosed() {
		return reasonField.isDisplayed();
	}
	
	
	
	

}
