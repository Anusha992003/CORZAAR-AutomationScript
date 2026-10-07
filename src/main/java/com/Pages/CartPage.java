package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	public void clickCourse() {
		elementUtils.click(courseCard);
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
		elementUtils.waitForVisibility(title);
		String text=elementUtils.getText(title);
		System.out.println("Navigated to: "+text + " page");
	}
	

}
