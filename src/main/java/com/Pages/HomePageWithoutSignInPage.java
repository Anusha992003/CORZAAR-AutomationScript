package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class HomePageWithoutSignInPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePageWithoutSignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="(//div[text()='C'])[1]")
	private WebElement logo;
	
	@FindBy(xpath="//h1[text()='Your next chapter starts here.']")
	private WebElement title;
	
	@FindBy(xpath="//a[text()='All Disciplines']")
	private WebElement allDps;
	
	@FindBy(xpath="(//a[contains(@class,'flex flex-col items-center justify-')])[1]")
	private WebElement designOption;
	
	@FindBy(xpath="(//select[contains(@class,'w-full bg-surface-alt dark:bg')])[1]")
	private WebElement valueInDiscipline;
	
	@FindBy(xpath="//span[contains(@class,'px-2.5 py-0.5 rounded-f')]")
	private List<WebElement> courseCards;
	
	@FindBy(xpath="(//span[text()='Design'])[1]")
	private WebElement designCard;
	
	public void clickLogo() {
		elementUtils.click(logo);
	}
	
	public void verifyPage() {
		Assert.assertTrue(title.isDisplayed());
	}
	
	public void allDisciplines() {
		elementUtils.click(allDps);
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("courses"));
		elementUtils.navigateBack();
	}
	
	public void clickDesignOption() {
		elementUtils.click(designOption);
	}
	
	public void verifyCoursesPage() {
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("courses"));
	}
	
	public void verifyDesignFilter() {
		String a=elementUtils.getAttribute(valueInDiscipline, "value");
		Assert.assertEquals(a, "Design");
	}
	
	public void verifyDesignCourseCards() {
		Assert.assertTrue(courseCards.size()>0, "No course cards are displayed");
		for(WebElement card:courseCards) {
			Assert.assertTrue(designCard.isDisplayed(),"Design discipline text is not displayed in a course card");
		}
		System.out.println("Validation passed: All displayed course cards contain design text");
		elementUtils.navigateBack();
	}
	
	@FindBy(xpath="//a[contains(text(),'View All (')]")
	private WebElement viewAllBtn;
	
	@FindBy(xpath="(//a[contains(@class,'group flex flex-col bg-wh')])[1]")
	private WebElement course1;
	
	@FindBy(xpath="//h1[contains(@class,'text-3xl sm:text-4xl font-black text-i')]")
	private WebElement courseDetailsPage;
	
	public void clickView() {
		elementUtils.click(viewAllBtn);
	}
	
	public void viewPage() {
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("courses"));
		elementUtils.navigateBack();
	}
	
	public void clickCourse() {
		elementUtils.click(course1);
	}
	
	public void verifyDetailsPageNavigation() {
		elementUtils.waitForVisibility(courseDetailsPage);
		Assert.assertTrue(courseDetailsPage.isDisplayed());
		elementUtils.navigateBack();
	}
	
	@FindBy(xpath="(//a[contains(@class,'p-6 bg-white dark:bg-da')])[1]")
	private WebElement institute;
	
	@FindBy(xpath="//div[contains(@class,'flex flex-col md:flex-row items-start md:items-center justify-between gap-6')]")
	private WebElement instDetailsPage;
	
	@FindBy(xpath="//span[contains(@class,'text-xs font-semibold text-b')]")
	private WebElement viewSyllabusBtn;
	
	public void clickInstitute() {
		elementUtils.click(institute);
	}
	
	public void verifyInstDetailsPage() {
		elementUtils.waitForVisibility(instDetailsPage);
		Assert.assertTrue(instDetailsPage.isDisplayed());
	}
	
	public void clickViewSyllabus() {
		elementUtils.click(viewSyllabusBtn);
	}
	
	public void verifyDisplayedPage() {
		elementUtils.waitForVisibility(courseDetailsPage);
		Assert.assertTrue(courseDetailsPage.isDisplayed());
		elementUtils.navigateBack();
		elementUtils.navigateBack();
	}
	
	@FindBy(xpath="//span[text()='View All Active Offers']")
	private WebElement offersBtn;
	
	public void clickOffersBtn() {
		elementUtils.click(offersBtn);
	}
	
	public void verifyOffersPage() {
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("offers"));
		elementUtils.navigateBack();
	}
	
	@FindBy(xpath="//span[text()='Get Certified & Eligible']")
	private WebElement getBtn;
	
	public void clickGet() {
		elementUtils.click(getBtn);
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("courses"));
	}
	
	@FindBy(xpath="//a[text()='All Courses']")
	private WebElement allCoursesLink;
	
	@FindBy(xpath="//a[text()='Scholarships & Offers']")
	private WebElement offersLink;
	
	@FindBy(xpath="//a[text()='Verify Credentials']")
	private WebElement verifyLink;
	
	@FindBy(xpath="//a[text()='Learner Space']")
	private WebElement learnerSpaceLink;
	
	@FindBy(xpath="//a[text()='Merchant Studio']")
	private WebElement merchantStudioLink;
	
	@FindBy(xpath="//a[text()='Admin Command Center']")
	private WebElement adminLink;
	
	@FindBy(xpath="//h1[text()='Learner Portal']")
	private WebElement learnerPortal;
	
	@FindBy(xpath="//h1[text()='Merchant & Institute Studio']")
	private WebElement merchantPortal;
	
	@FindBy(xpath="//h1[text()='Platform Command Center']")
	private WebElement adminPortal;
	
	public void allLink() {
		elementUtils.click(allCoursesLink);
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("courses"));
		elementUtils.navigateBack();
	}
	
	public void offersLink() {
		elementUtils.click(offersLink);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("offers"));
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("offers"));
		elementUtils.navigateBack();
	}
	
	public void verifyLink() {
		elementUtils.click(verifyLink);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("verify"));
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("verify"));
		elementUtils.navigateBack();
	}
	
	public void learnerLink() {
		elementUtils.waitForVisibility(learnerSpaceLink);
		elementUtils.click(learnerSpaceLink);
		Assert.assertTrue(learnerPortal.isDisplayed());
		elementUtils.navigateBack();
	}
	
	public void merchantLink() {
		elementUtils.click(merchantStudioLink);
		Assert.assertTrue(merchantPortal.isDisplayed());
		elementUtils.navigateBack();
	}
	
	public void adminLink() {
		elementUtils.click(adminLink);
		Assert.assertTrue(adminPortal.isDisplayed());
		elementUtils.navigateBack();
	}
	
	

}
