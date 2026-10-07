package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	private WebElement searchResult;
	
	@FindBy(xpath="//h3[contains(@class,'text-base font-bold ')]")
	private WebElement invalidSearch;
	
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
		System.out.println("Search count: "+count);
	}
	
	public String verifySearchResult() {
		return elementUtils.getText(searchResult);
	}
	
	public void verifyInvalidSearch() {
		String text=elementUtils.getText(invalidSearch);
		System.out.println("Invalid search: "+text);
	}

}
