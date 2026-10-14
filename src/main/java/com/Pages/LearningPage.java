package com.Pages;

import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy(xpath="//div//strong")
	private WebElement enrolledPrograms;
	
	@FindBy(xpath="//div[contains(@class,'flex items-start justify-between gap-2 mb')]")
	private List<WebElement> displayedPrograms;
	
	@FindBy(xpath="//*[text()='No curriculum items registered for this program.']")
	private List<WebElement> noModuleMsg;
	
	public void clickLearningModule() {
		elementUtils.click(learning);
	}
	
	public void clickCourse() {
		elementUtils.click(selectCourse);
	}
	
	public void verifyEnrolledProgramsCount() {
		String pro=elementUtils.getText(enrolledPrograms);
		int a=Integer.parseInt(pro.replaceAll("\\D+", ""));
		int b=displayedPrograms.size();
		Assert.assertEquals(a, b,"Enrolled programs are not equal as displayed in the screen");
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
	
	public void verifyModuleDisplay() {
		elementUtils.waitForVisibilityOfAllElements(noModuleMsg);
		if(!noModuleMsg.isEmpty() && noModuleMsg.get(0).isDisplayed()) {
			System.out.println("BUG: After completing the first module, the remaining modules disappear and the message "+"No curriculum items registered for this program"+ " is displayed.");
		}
//		else if(module2.isEmpty()) {
//			System.out.println("BUG: The second module is not displayed after completing the first module");
//		}
		else {
			System.out.println("The second module is displayed and can be accessed");
		}
	}
}
