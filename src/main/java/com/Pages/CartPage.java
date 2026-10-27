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

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class CartPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="(//span[contains(@class,'text-xs font-semibold text-brand flex items')])[1]")
	private WebElement courseCard;
	
	@FindBy(xpath="(//span[contains(@class,'text-xs font-semibold text-brand flex items')])[2]")
	private WebElement course1;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//span[contains(@class,'absolute -top-1 -right-1 bg-brand text-whit')]")
	private WebElement cartCount;
	
	@FindBy(xpath="//a[contains(@class,'relative p-2 text-ink-muted hover:text-ink h')]")
	private WebElement cartIcon;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement promoCodeField;
	
	@FindBy(xpath="//span[text()='Apply']")
	private WebElement applyBtn;
	
	@FindBy(xpath="//span[text()='Tuition Subtotal']//following-sibling::span")
	private WebElement courseFee;
	
	@FindBy(xpath="//span[contains(normalize-space(.),'Promo Discount')]/following-sibling::span")
	private WebElement discountAmt;
	
	@FindBy(xpath="//span[text()='Total Due']/following-sibling::span")
	private WebElement totalAmt;
	
	@FindBy(xpath="(//button[contains(@class,'inline-flex items-center justif')])[2]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//h1[contains(@class,'text-2xl sm:text-3xl font-black text-in')]")
	private WebElement title;
	
	@FindBy(xpath="//h1[contains(@class,'text-3xl sm:text-4xl font-black text-')]")
	private WebElement detailsPageTitle;
	
	@FindBy(xpath="//*[text()='Coupon Applied!']")
	private List<WebElement> popup;
	
	@FindBy(xpath="//h3[contains(@class,'text-sm font-bold text-ink dark')]")
	private List<WebElement> courseInLearning;
	
	@FindBy(xpath="(//h3[contains(@class,'text-base font-bold text-ink dark:text-da')])[3]")
	private WebElement courseName;
	
	@FindBy(xpath="//span[contains(text(),'Course (')]")
	private WebElement courseCount;
	
	@FindBy(xpath="//div[contains(@class,'flex items-start sm:items-center justify-betwee')]")
	private List<WebElement> displayedCourse;
	
	@FindBy(xpath="(//button[@title='Remove item'])[1]")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//*[text()='Item Removed']")
	private WebElement deleteMsg;
	
	@FindBy(xpath="//*[text()='Your Cart is Empty']")
	private WebElement emptyCartMsg;
	
	@FindBy(xpath="//input[@placeholder=\"Friend's Referral Code\"]")
	private WebElement referralCodeField;
	
	@FindBy(xpath="//span[contains(@class,'text-base font-black text-ink dark:text')]")
	private List<WebElement> courseFees;
	
	@FindBy(xpath="//span[contains(@class,'text-lg text-brand')]")
	private WebElement totalFees;
	
	public void verifyCourseCount() {
		String a=elementUtils.getText(courseCount);
		int a1=Integer.parseInt(a.replaceAll("\\D+", ""));
		int b=displayedCourse.size();
		Assert.assertEquals(a1, b);
	}
	
	public void addCoursesToCart() {
		FilterPage filterPage = new FilterPage(DriverFactory.getDriver());
		filterPage.clickCoursesBtn();
		elementUtils.click(course1);
		pageRefresh();
		clickCartBtn();
		clickCartIcon();
	}
	
	public void verifyDelete() {
		//addCoursesToCart();
		elementUtils.click(deleteBtn);
		System.out.println("Message after successful delete: "+elementUtils.getText(deleteMsg));
		String a=elementUtils.getText(courseCount);
		System.out.println("Count of course in cart after deletion: "+a);
	}
	
	public void verifyEmptyCart() {
		clickCartIcon();
		System.out.println("Message when cart is empty: "+elementUtils.getText(emptyCartMsg));
	}
	
	public String getSelectedCourseName() {
		String a=elementUtils.getText(courseName);
		return a.trim();
	}
	
	public boolean isCourseDisplayed(String expectedCourse) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> courses=wait.until(ExpectedConditions.visibilityOfAllElements(courseInLearning));
	    for (WebElement c : courses) {
	    	String c1= elementUtils.getText(c).replaceAll("\\s+", " ").trim();
			if(c1.equalsIgnoreCase(expectedCourse.replaceAll("\\s+", " ").trim())) {
				return true;
			}
		}
	    return false;
	}
	
	public void clickCourse() {
		elementUtils.click(courseCard);
	}
	
	public void getDetailsPageTitle() {
		String a=elementUtils.getText(detailsPageTitle);
		System.out.println("Course details page title is: "+a);
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public void clickCartBtn() {
		elementUtils.waitForVisibility(addToCartBtn);
		elementUtils.click(addToCartBtn);
	}
	
	public void cartCount() {
		String count=elementUtils.getText(cartCount);
		System.out.println("Cart is added with "+ count + " course");
	}
	
	public void clickCartIcon() {
		elementUtils.click(cartIcon);
	}
	
	public void enterCode(String code) {
		elementUtils.sendKeys(promoCodeField, code);
	}
	
	public void enterReferralCode() {
		elementUtils.sendKeys(referralCodeField, "REFAD6B85BD");
	}
	
	public void validateOptionalReferral() {
		elementUtils.sendKeys(referralCodeField, "");
		elementUtils.click(submitBtn);
		Assert.assertTrue(title.isDisplayed(),"Form does not proceed with empty referral code");
	}
	
	public void clickApplyBtn() {
		elementUtils.click(applyBtn);
	}
	
	public void verifyFees() {
		String fees = elementUtils.getText(courseFee);
		int f = Integer.parseInt(fees.replace("\u20B9", "").replace(",", "").trim());
		String discount = elementUtils.getText(discountAmt);
		int d = Integer.parseInt(discount.replace("\u20B9", "").replace(",", "").replace("-", "").trim());
		int expectedTot = f - d;
		String totAmt =elementUtils.getText(totalAmt);
		int actualTot = Integer.parseInt(totAmt.replace("\u20B9", "").replace(",", "").trim());
		System.out.println("Course fee: "+ f);
		System.out.println("Discount: "+ d);
		System.out.println("Expected total: "+ expectedTot);
		System.out.println("Actual Total: "+ actualTot);
		Assert.assertEquals(actualTot, expectedTot, 0.01 , "Total payable amount is incorrect");
	}
	
	public void clickPayAndEnrollBtn() {
		elementUtils.click(submitBtn);
	}
	
	public void getTitle() {
		//elementUtils.waitForVisibility(title);
		String text=elementUtils.getText(title);
		System.out.println("Navigated to: "+text + " page");
	}
	
	public void validateInvaildCoupon() {
		elementUtils.sendKeys(promoCodeField, "@#$");
		elementUtils.click(applyBtn);
		if(!popup.isEmpty() && popup.get(0).isDisplayed()) {
			System.out.println("BUG: Invalid coupon code was accepted");
		}
		else {
			System.out.println("Invalid coupon code was not accepted");
		}
	}
	
	public void addTwoCourseFees() {
		addCoursesToCart();
		elementUtils.waitForVisibilityOfAllElements(courseFees);
		System.out.println("No.of fee elements: "+courseFees.size());
		double calTot=0;
		for (WebElement fee : courseFees) {
			String fee1=elementUtils.getText(fee).trim();
			System.out.println("Fee text: "+fee1);
			if(fee1.equalsIgnoreCase("Free")) {
				calTot+=0;
			}
			else {
				String amount=fee1.replaceAll("[^0-9.]", "");
				if(!amount.isEmpty()) {
					calTot+=Double.parseDouble(amount);
				}
			}
		}
		System.out.println("cal tot: "+calTot);
		String total=elementUtils.getText(totalFees).trim();
		System.out.println("tot text: "+total);
		String amount=total.replaceAll("[^0-9.]", "");
		double displayedTotal=Double.parseDouble(amount);
		System.out.println("dis tot: "+displayedTotal);
		Assert.assertEquals(calTot, displayedTotal,0.01,"Total due does not match the sum of course fees");
	}
	

}
