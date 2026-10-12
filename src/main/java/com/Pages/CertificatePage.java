package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class CertificatePage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public CertificatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//h2[contains(@class,'text-2xl font-bl')]")
	private WebElement courseName;
	
	@FindBy(xpath="//span[contains(@class,'font-bold text-ink dark:text-dark-ink t')]")
	private WebElement displayedCourseName;
	
	@FindBy(xpath="//span[text()='Verification URL']")
	private WebElement urlLink;
	
	@FindBy(xpath="//h1[contains(@class,'text-3xl sm:text-4xl font-bla')]")
	private WebElement title;
	
	@FindBy(xpath="//span[contains(@class,'font-mono font-bold text-brand')]")
	private WebElement certificateID;
	
	@FindBy(id="certificate-identification-number")
	private WebElement inputID;
	
	@FindBy(xpath="//span[text()=\"Official Certificate View\"]")
	private WebElement viewBtn;
	
	@FindBy(xpath="//span[contains(@class,'font-mono text-xs font-bold text-brand')]")
	private WebElement certificateID2;
	
	@FindBy(xpath="//h1[text()='CORZAAR Certificate Verification']")
	private WebElement page;
	
	public String getCourseNameInLearningSpace() {
		String a= elementUtils.getText(courseName);
		return a.trim();
	}
	
	public String getCourseNameInCertificate() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement a=wait.until(ExpectedConditions.visibilityOf(displayedCourseName));
		return a.getText().trim();
	}
	
	public void clickURL() {
		elementUtils.click(urlLink);
	}
	
	public void getTitle() {
		String text=elementUtils.getText(title);
		System.out.println("Title: "+ text);
	}
	
	public void verifyCertificateID() {
		String a= inputID.getAttribute("value");
		String b = elementUtils.getText(certificateID2);
		Assert.assertEquals(a, b);
	}
	
	public void clickViewBtn() {
		elementUtils.getParentWindow();
		elementUtils.click(viewBtn);
	}
	
	public void verifyPage() {
		elementUtils.switchToNewWindow();
		String expectedTitle = elementUtils.getText(page);
		System.out.println("Title of navigated page: "+expectedTitle);
		elementUtils.switchBackToParentWindow();
	}
	

}
