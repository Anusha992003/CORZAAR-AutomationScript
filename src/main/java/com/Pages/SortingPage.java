package com.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utilities.ElementUtils;

public class SortingPage {
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public SortingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//select[contains(@class,'bg-surface-alt dark:bg-slate-800 border border-border dark:border-dark-border rounded-l')]")
	private WebElement sortDropdown;
	
	@FindBy(xpath="//span[contains(@class,'text-xs font-bold text-ink dark:text-dark-ink')]")
	private List<WebElement> ratings;
	
	@FindBy(xpath="//span[contains(@class,'text-base font-black text')]")
	private List<WebElement> prices;
	
	public void clickSortDropdown() {
		elementUtils.click(sortDropdown);
	}
	
	public void selectSortOption(String option) {
		Select select=new Select(sortDropdown);
		select.selectByVisibleText(option);
	}
	
	public void validateHighestRated() {
		List<Double> actualRatings = new ArrayList<Double>();
		for (WebElement r : ratings) {
			String r1 = elementUtils.getText(r);
			double r2 = Double.parseDouble(r1);
			actualRatings.add(r2);
		}
		List<Double> expectedRatings = new ArrayList<Double>(actualRatings);
		expectedRatings.sort(Collections.reverseOrder());
		Assert.assertEquals(actualRatings, expectedRatings, "Courses are not sorted by Highest Rated");
	}
	
	public void validatePriceLowToHigh() {
		List<Integer> actualPrices = new ArrayList<Integer>();
		for (WebElement p : prices) {
			String p1 = elementUtils.getText(p);
			int price;
			if(p1.equalsIgnoreCase("Free")) {
				price=0;
			}
			else {
				price = Integer.parseInt(p1.replaceAll("[^0-9]", ""));
			}
			actualPrices.add(price);
		}
		List<Integer> expectedPrices = new ArrayList<Integer>(actualPrices);
		Collections.sort(expectedPrices);
		Assert.assertEquals(actualPrices, expectedPrices, "Courses are not sorted by Price Low to High");
	}
	
	public void validatePriceHighToLow() {
		List<Integer> actualPrices = new ArrayList<Integer>();
		for (WebElement p : prices) {
			String p1 = elementUtils.getText(p);
			int price;
			if(p1.equalsIgnoreCase("Free")) {
				price=0;
			}
			else {
				price = Integer.parseInt(p1.replaceAll("[^0-9]", ""));
			}
			actualPrices.add(price);
		}
		List<Integer> expectedPrices = new ArrayList<Integer>(actualPrices);
		expectedPrices.sort(Collections.reverseOrder());
		Assert.assertEquals(actualPrices, expectedPrices, "Courses are not sorted by Price High to Low");
	}

}
