package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.driverFactory.DriverFactory;
import com.utilities.ElementUtils;

public class HomePage {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@class='flex items-center gap-2 group']")
	private WebElement homePageBtn;
	
	@FindBy(xpath="//h1[contains(@class,'text-4xl sm:text-5xl lg:text-6xl')]")
	private WebElement homePageTitle;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement exploreBtn;
	
	@FindBy(xpath="//span[contains(@class,'text-xs sm:text-sm font')]")
	private WebElement searchCount;
	
	@FindBy(xpath="//h3[contains(@class,'text-base font-bold text-ink')]")
	private List<WebElement> searchResult;
	
	@FindBy(xpath="//h3[contains(@class,'text-base font-bold ')]")
	private WebElement invalidSearch;
	
	@FindBy(xpath="//a[contains(@class,'group flex flex-col bg-white dark:bg-')]")
	private List<WebElement> courseCount;
	
	public void clickHomePageBtn() {
		elementUtils.click(homePageBtn);
	}
	
	public void getHomePageTitle() {
		String title= elementUtils.getText(homePageTitle);
		System.out.println("Heading of the Homepage: "+ title);
	}
	
	public void enterTextInSearchField(String search) {
		elementUtils.sendKeys(searchField, search);
	}
	
	public void clickExploreBtn() {
		elementUtils.click(exploreBtn);
	}
	
	public void verifySearchCount() {
		String count=elementUtils.getText(searchCount);
		int c=Integer.parseInt(count.replaceAll("\\D+", ""));
		int d=courseCount.size();
		Assert.assertEquals(c, d,"Course count is not matching");
		System.out.println("Search count: "+count);
	}
	
	public void verifySearchResult() {
		String a=searchField.getAttribute("value");
		Assert.assertFalse(searchResult.isEmpty(),"No courses displayed");
		for (WebElement course : searchResult) {
			String b=elementUtils.getText(course);
			Assert.assertTrue(b.toLowerCase().contains(a.toLowerCase()),"Course does not match search");
		}
		//Assert.assertEquals(a, b,"Course does not match");
		System.out.println("Search result is displayed correctly");
	}
	
	public void verifyInvalidSearch() {
		elementUtils.waitForVisibility(invalidSearch);
		Assert.assertTrue(invalidSearch.isDisplayed(),"Validation message is not displayed for invalid input");
		String text=elementUtils.getText(invalidSearch);
		System.out.println("Invalid search: "+text);
	}

}
