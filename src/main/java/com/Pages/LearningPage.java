package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class LearningPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public LearningPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[contains(@class,'hidden sm:flex items-center gap-1.5')]")
	private WebElement learning;
	
	@FindBy(xpath="//h3[text()='DIS']")
	private WebElement selectCourse;
	
	@FindBy(xpath="//h2[contains(@class,'text-2xl font-black text-i')]")
	private WebElement verifyCourseDisplay;
	
	@FindBy(xpath="//span[contains(@class,'text-brand font-black text-sm')]")
    private WebElement courseStatus;
	
	@FindBy(xpath="(//div[contains(@class,'mt-0.5 text-brand shrink-0')])[1]")
	private WebElement module1;
	
	@FindBy(xpath="(//div[contains(@class,'mt-0.5 text-brand shrink-0')])[2]")
	private WebElement module2;
	
	@FindBy(xpath="(//div[contains(@class,'mt-0.5 text-brand shrink-0')])[3]")
	private WebElement module3;
	
	@FindBy(xpath="//h3[text()='Official Certificate Earned!']")
	private WebElement certificate;
	
	public void clickLearningModule() {
		elementUtils.click(learning);
	}
	
	public void clickCourse() {
		elementUtils.click(selectCourse);
	}
	
	public void verifyCourse() {
		String text=elementUtils.getText(selectCourse);
		String text1=elementUtils.getText(verifyCourseDisplay);
		if(text.equalsIgnoreCase(text1)) {
			System.out.println("Selected course page is displayed correctly");
		}
		else {
			System.out.println("Course is not displayed correctly");
		}
	}
	
	public void getStatus() {
		String a=elementUtils.getText(courseStatus);
		System.out.println("Status of the course completion: "+a);
	}
	
	public void clickModule1() {
		elementUtils.click(module1);
	}
	
	public void clickModule2() {
		elementUtils.click(module2);
	}
	
	public void clickModule3() {
		elementUtils.click(module3);
	}
	
	public void verifyCertificate() {
		String b= elementUtils.getText(certificate);
		System.out.println("After completion of course - "+b);
	}
}
